package com.notesapp.presentation.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0010J\u001a\u0010\u0019\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100\u001bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "googleAuthManager", "Lcom/notesapp/data/datasources/remote/GoogleAuthManager;", "(Lcom/notesapp/data/datasources/remote/GoogleAuthManager;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentUser", "Lcom/notesapp/domain/repositories/User;", "getCurrentUser", "handleSignInError", "", "message", "", "handleSignInResult", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "isSignedIn", "", "signOut", "startSignIn", "onGetSignInIntent", "Lkotlin/Function1;", "Landroid/content/Intent;", "AuthState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.data.datasources.remote.GoogleAuthManager googleAuthManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notesapp.presentation.viewmodels.AuthViewModel.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.AuthViewModel.AuthState> authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notesapp.domain.repositories.User> currentUser = null;
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.datasources.remote.GoogleAuthManager googleAuthManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.AuthViewModel.AuthState> getAuthState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notesapp.domain.repositories.User> getCurrentUser() {
        return null;
    }
    
    public final void startSignIn(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.content.Intent, kotlin.Unit> onGetSignInIntent) {
    }
    
    public final void handleSignInResult(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    public final void handleSignInError(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void signOut() {
    }
    
    public final boolean isSignedIn() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Error;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Idle;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Loading;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Success;", "app_debug"})
    public static abstract class AuthState {
        
        private AuthState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Error;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.notesapp.presentation.viewmodels.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.notesapp.presentation.viewmodels.AuthViewModel.AuthState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Idle;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "()V", "app_debug"})
        public static final class Idle extends com.notesapp.presentation.viewmodels.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            public static final com.notesapp.presentation.viewmodels.AuthViewModel.AuthState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Loading;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "()V", "app_debug"})
        public static final class Loading extends com.notesapp.presentation.viewmodels.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            public static final com.notesapp.presentation.viewmodels.AuthViewModel.AuthState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState$Success;", "Lcom/notesapp/presentation/viewmodels/AuthViewModel$AuthState;", "()V", "app_debug"})
        public static final class Success extends com.notesapp.presentation.viewmodels.AuthViewModel.AuthState {
            @org.jetbrains.annotations.NotNull()
            public static final com.notesapp.presentation.viewmodels.AuthViewModel.AuthState.Success INSTANCE = null;
            
            private Success() {
            }
        }
    }
}