package com.notesapp.data.datasources.remote

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.services.drive.DriveScopes
import com.notesapp.domain.repositories.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Google authentication manager
 */
@Singleton
class GoogleAuthManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()
    
    private val googleSignInClient: GoogleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestScopes(Scope(DriveScopes.DRIVE_FILE))
            .build()
        
        GoogleSignIn.getClient(context, gso)
    }
    
    init {
        // Check if user is already signed in
        val account = GoogleSignIn.getLastSignedInAccount(context)
        account?.let {
            _currentUser.value = mapToUser(it)
        }
    }
    
    /**
     * Get Google Sign-In client for activity usage
     */
    fun getSignInClient(): GoogleSignInClient = googleSignInClient
    
    /**
     * Handle successful sign-in
     */
    fun handleSignInResult(account: GoogleSignInAccount?) {
        _currentUser.value = account?.let { mapToUser(it) }
    }
    
    /**
     * Sign out user
     */
    suspend fun signOut() {
        try {
            googleSignInClient.signOut()
            _currentUser.value = null
        } catch (e: Exception) {
            // Handle sign out error
        }
    }
    
    /**
     * Get Google Account Credential for API access
     */
    fun getCredential(): GoogleAccountCredential? {
        val account = GoogleSignIn.getLastSignedInAccount(context)
        return account?.let {
            GoogleAccountCredential.usingOAuth2(
                context,
                listOf(DriveScopes.DRIVE_FILE)
            ).setSelectedAccount(it.account)
        }
    }
    
    /**
     * Check if user is signed in
     */
    fun isSignedIn(): Boolean = _currentUser.value != null
    
    /**
     * Get current user
     */
    fun getCurrentUser(): User? = _currentUser.value
    
    private fun mapToUser(account: GoogleSignInAccount): User {
        return User(
            id = account.id ?: "",
            email = account.email ?: "",
            displayName = account.displayName,
            photoUrl = account.photoUrl?.toString()
        )
    }
}