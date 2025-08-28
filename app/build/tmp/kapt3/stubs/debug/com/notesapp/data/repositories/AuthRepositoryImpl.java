package com.notesapp.data.repositories;

/**
 * Implementation of AuthRepository
 * For now, provides a basic mock implementation
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000bH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/notesapp/data/repositories/AuthRepositoryImpl;", "Lcom/notesapp/domain/repositories/AuthRepository;", "()V", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notesapp/domain/repositories/User;", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSignedIn", "", "observeAuthState", "Lkotlinx/coroutines/flow/Flow;", "signInWithGoogle", "Lkotlin/Result;", "signInWithGoogle-IoAF18A", "signOut", "", "signOut-IoAF18A", "app_debug"})
public final class AuthRepositoryImpl implements com.notesapp.domain.repositories.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notesapp.domain.repositories.User> _currentUser = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.notesapp.domain.repositories.User> observeAuthState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.notesapp.domain.repositories.User> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isSignedIn(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}