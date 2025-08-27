package com.notesapp.domain.repositories

import kotlinx.coroutines.flow.Flow

/**
 * Данные пользователя
 */
data class User(
    val id: String,
    val email: String,
    val displayName: String?,
    val photoUrl: String?
)

/**
 * Интерфейс репозитория для аутентификации
 */
interface AuthRepository {
    
    /**
     * Наблюдает за состоянием аутентификации пользователя
     */
    fun observeAuthState(): Flow<User?>
    
    /**
     * Выполняет вход через Google
     */
    suspend fun signInWithGoogle(): Result<User>
    
    /**
     * Выполняет выход пользователя
     */
    suspend fun signOut(): Result<Unit>
    
    /**
     * Получает текущего пользователя
     */
    suspend fun getCurrentUser(): User?
    
    /**
     * Проверяет, авторизован ли пользователь
     */
    suspend fun isSignedIn(): Boolean
}