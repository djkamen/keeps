package com.notesapp.data.repositories

import com.notesapp.domain.repositories.AuthRepository
import com.notesapp.domain.repositories.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of AuthRepository
 * For now, provides a basic mock implementation
 */
@Singleton
class AuthRepositoryImpl @Inject constructor(
    // TODO: Add Google Sign-In dependencies
) : AuthRepository {
    
    private val _currentUser = MutableStateFlow<User?>(
        // For now, create a default test user
        User(
            id = "test_user_123",
            email = "test@example.com",
            displayName = "Test User",
            photoUrl = null
        )
    )
    
    override fun observeAuthState(): Flow<User?> {
        return _currentUser.asStateFlow()
    }
    
    override suspend fun signInWithGoogle(): Result<User> {
        return try {
            // TODO: Implement Google Sign-In
            val user = User(
                id = "google_user_123",
                email = "user@gmail.com",
                displayName = "Google User",
                photoUrl = null
            )
            _currentUser.value = user
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun signOut(): Result<Unit> {
        return try {
            _currentUser.value = null
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getCurrentUser(): User? {
        return _currentUser.value
    }
    
    override suspend fun isSignedIn(): Boolean {
        return _currentUser.value != null
    }
}