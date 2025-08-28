package com.notesapp.presentation.ui.auth

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.notesapp.presentation.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleSignInScreen(
    onSignInSuccess: () -> Unit,
    onSkip: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val authState by viewModel.authState.collectAsState()
    
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            Log.d("GoogleSignInScreen", "Sign-in successful: ${account?.email}")
            viewModel.handleSignInResult(account)
            onSignInSuccess()
        } catch (e: ApiException) {
            Log.e("GoogleSignInScreen", "Google Sign-In failed with status code: ${e.statusCode}", e)
            val errorMessage = when (e.statusCode) {
                10 -> "Ошибка конфигурации Google Sign-In (код 10). Проверьте настройки в Google Console."
                12501 -> "Вход отменен пользователем"
                7 -> "Нет подключения к интернету"
                else -> "Ошибка входа (код ${e.statusCode}): ${e.message}"
            }
            viewModel.handleSignInError(errorMessage)
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Вход в Google аккаунт",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Войдите в свой Google аккаунт, чтобы синхронизировать заметки с Google Drive",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        val currentAuthState = authState
        
        when (currentAuthState) {
            is AuthViewModel.AuthState.Loading -> {
                CircularProgressIndicator()
            }
            is AuthViewModel.AuthState.Error -> {
                Text(
                    text = currentAuthState.message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            else -> { /* No special handling needed */ }
        }
        
        Button(
            onClick = {
                viewModel.startSignIn { signInIntent ->
                    launcher.launch(signInIntent)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            enabled = currentAuthState !is AuthViewModel.AuthState.Loading
        ) {
            Text("Войти в Google")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        TextButton(
            onClick = onSkip,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Пропустить (только локальное сохранение)")
        }
    }
}