package com.notesapp.data.datasources.remote;

/**
 * Google authentication manager
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u001dR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/notesapp/data/datasources/remote/GoogleAuthManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notesapp/domain/repositories/User;", "currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentUser", "()Lkotlinx/coroutines/flow/StateFlow;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInClient$delegate", "Lkotlin/Lazy;", "getCredential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "getSignInClient", "handleSignInResult", "", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "isSignedIn", "", "mapToUser", "signOut", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GoogleAuthManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notesapp.domain.repositories.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notesapp.domain.repositories.User> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy googleSignInClient$delegate = null;
    
    @javax.inject.Inject()
    public GoogleAuthManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notesapp.domain.repositories.User> getCurrentUser() {
        return null;
    }
    
    private final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    /**
     * Get Google Sign-In client for activity usage
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getSignInClient() {
        return null;
    }
    
    /**
     * Handle successful sign-in
     */
    public final void handleSignInResult(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    /**
     * Sign out user
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get Google Account Credential for API access
     */
    @org.jetbrains.annotations.Nullable()
    public final com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential getCredential() {
        return null;
    }
    
    /**
     * Check if user is signed in
     */
    public final boolean isSignedIn() {
        return false;
    }
    
    /**
     * Get current user
     */
    @org.jetbrains.annotations.Nullable()
    public final com.notesapp.domain.repositories.User getCurrentUser() {
        return null;
    }
    
    private final com.notesapp.domain.repositories.User mapToUser(com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
        return null;
    }
}