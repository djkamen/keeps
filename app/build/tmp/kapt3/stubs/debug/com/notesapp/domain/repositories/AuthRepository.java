package com.notesapp.domain.repositories;

/**
 * Интерфейс репозитория для аутентификации
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bH&J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\u0004J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u0004\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000f"}, d2 = {"Lcom/notesapp/domain/repositories/AuthRepository;", "", "getCurrentUser", "Lcom/notesapp/domain/repositories/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSignedIn", "", "observeAuthState", "Lkotlinx/coroutines/flow/Flow;", "signInWithGoogle", "Lkotlin/Result;", "signInWithGoogle-IoAF18A", "signOut", "", "signOut-IoAF18A", "app_debug"})
public abstract interface AuthRepository {
    
    /**
     * Наблюдает за состоянием аутентификации пользователя
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.notesapp.domain.repositories.User> observeAuthState();
    
    /**
     * Получает текущего пользователя
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.notesapp.domain.repositories.User> $completion);
    
    /**
     * Проверяет, авторизован ли пользователь
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isSignedIn(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}