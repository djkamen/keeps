package com.notesapp.data.repositories;

/**
 * Implementation of CollaborationRepository
 * For now, provides a basic mock implementation
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ2\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J4\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"Lcom/notesapp/data/repositories/CollaborationRepositoryImpl;", "Lcom/notesapp/domain/repositories/CollaborationRepository;", "()V", "_noteChanges", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/notesapp/domain/entities/NoteChange;", "broadcastChange", "Lkotlin/Result;", "", "change", "broadcastChange-gIAlu-s", "(Lcom/notesapp/domain/entities/NoteChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangeHistory", "", "noteId", "", "limit", "", "getChangeHistory-0E7RQCE", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinNote", "user", "Lcom/notesapp/domain/entities/ActiveUser;", "joinNote-0E7RQCE", "(Ljava/lang/String;Lcom/notesapp/domain/entities/ActiveUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveNote", "userId", "leaveNote-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "observeNoteChanges", "updateCursorPosition", "position", "updateCursorPosition-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CollaborationRepositoryImpl implements com.notesapp.domain.repositories.CollaborationRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.notesapp.domain.entities.NoteChange> _noteChanges = null;
    
    @javax.inject.Inject()
    public CollaborationRepositoryImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.notesapp.domain.entities.NoteChange> observeNoteChanges(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.notesapp.domain.entities.ActiveUser>> observeActiveUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
        return null;
    }
}