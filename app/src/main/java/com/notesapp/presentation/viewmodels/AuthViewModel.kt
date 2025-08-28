package com.notesapp.presentation.viewmodels

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.notesapp.data.datasources.remote.GoogleAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val googleAuthManager: GoogleAuthManager
) : ViewModel() {
    
    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        object Success : AuthState()
        data class Error(val message: String) : AuthState()
    }
    
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    
    val currentUser = googleAuthManager.currentUser
    
    fun startSignIn(onGetSignInIntent: (Intent) -> Unit) {
        _authState.value = AuthState.Loading
        try {
            val signInIntent = googleAuthManager.getSignInClient().signInIntent
            onGetSignInIntent(signInIntent)
        } catch (e: Exception) {
            _authState.value = AuthState.Error("Ошибка при запуске входа: ${e.message}")
        }
    }
    
    fun handleSignInResult(account: GoogleSignInAccount?) {
        viewModelScope.launch {
            try {
                Log.d("AuthViewModel", "Handling sign-in result: ${account?.email}")
                googleAuthManager.handleSignInResult(account)
                if (account != null) {
                    Log.d("AuthViewModel", "Sign-in successful for: ${account.email}")
                    _authState.value = AuthState.Success
                } else {
                    Log.w("AuthViewModel", "Sign-in failed: no account returned")
                    _authState.value = AuthState.Error("Не удалось войти в аккаунт")
                }
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Exception during sign-in handling", e)
                _authState.value = AuthState.Error("Ошибка обработки входа: ${e.message}")
            }
        }
    }
    
    fun handleSignInError(message: String) {
        Log.e("AuthViewModel", "Sign-in error: $message")
        _authState.value = AuthState.Error("Ошибка входа: $message")
    }
    
    fun signOut() {
        viewModelScope.launch {
            try {
                googleAuthManager.signOut()
                _authState.value = AuthState.Idle
            } catch (e: Exception) {
                _authState.value = AuthState.Error("Ошибка при выходе: ${e.message}")
            }
        }
    }
    
    fun isSignedIn(): Boolean {
        return googleAuthManager.isSignedIn()
    }
}