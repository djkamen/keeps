package com.notesapp.domain.usecases;

/**
 * Use Case для совместной работы в реальном времени
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u00182\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010\r\u001a\u00020\u000eJ4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006 "}, d2 = {"Lcom/notesapp/domain/usecases/RealTimeCollaborationUseCase;", "", "collaborationRepository", "Lcom/notesapp/domain/repositories/CollaborationRepository;", "(Lcom/notesapp/domain/repositories/CollaborationRepository;)V", "broadcastChange", "Lkotlin/Result;", "", "change", "Lcom/notesapp/domain/entities/NoteChange;", "broadcastChange-gIAlu-s", "(Lcom/notesapp/domain/entities/NoteChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinNote", "noteId", "", "user", "Lcom/notesapp/domain/entities/ActiveUser;", "joinNote-0E7RQCE", "(Ljava/lang/String;Lcom/notesapp/domain/entities/ActiveUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveNote", "userId", "leaveNote-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "", "observeNoteChanges", "updateCursorPosition", "position", "", "updateCursorPosition-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RealTimeCollaborationUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.repositories.CollaborationRepository collaborationRepository = null;
    
    @javax.inject.Inject()
    public RealTimeCollaborationUseCase(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.repositories.CollaborationRepository collaborationRepository) {
        super();
    }
    
    /**
     * Наблюдает за изменениями в заметке
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.notesapp.domain.entities.NoteChange> observeNoteChanges(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
        return null;
    }
    
    /**
     * Наблюдает за активными пользователями
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.notesapp.domain.entities.ActiveUser>> observeActiveUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
        return null;
    }
}