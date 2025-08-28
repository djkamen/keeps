package com.notesapp.data.datasources.remote;

/**
 * Firebase Realtime Database service for collaboration
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0015"}, d2 = {"Lcom/notesapp/data/datasources/remote/FirebaseRealtimeService;", "", "()V", "database", "Lcom/google/firebase/database/DatabaseReference;", "observeNoteChanges", "Lkotlinx/coroutines/flow/Flow;", "Lcom/notesapp/domain/entities/NoteChange;", "noteId", "", "publishChange", "Lkotlin/Result;", "", "change", "publishChange-gIAlu-s", "(Lcom/notesapp/domain/entities/NoteChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUserActive", "user", "Lcom/notesapp/domain/entities/ActiveUser;", "setUserActive-0E7RQCE", "(Ljava/lang/String;Lcom/notesapp/domain/entities/ActiveUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FirebaseRealtimeService {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference database = null;
    
    @javax.inject.Inject()
    public FirebaseRealtimeService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.notesapp.domain.entities.NoteChange> observeNoteChanges(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
        return null;
    }
}