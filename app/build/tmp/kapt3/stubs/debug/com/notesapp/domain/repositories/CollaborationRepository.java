package com.notesapp.domain.repositories;

/**
 * Интерфейс репозитория для функций совместной работы
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\u001b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u000b\u001a\u00020\fH&J4\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"Lcom/notesapp/domain/repositories/CollaborationRepository;", "", "broadcastChange", "Lkotlin/Result;", "", "change", "Lcom/notesapp/domain/entities/NoteChange;", "broadcastChange-gIAlu-s", "(Lcom/notesapp/domain/entities/NoteChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangeHistory", "", "noteId", "", "limit", "", "getChangeHistory-0E7RQCE", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinNote", "user", "Lcom/notesapp/domain/entities/ActiveUser;", "joinNote-0E7RQCE", "(Ljava/lang/String;Lcom/notesapp/domain/entities/ActiveUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveNote", "userId", "leaveNote-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeActiveUsers", "Lkotlinx/coroutines/flow/Flow;", "observeNoteChanges", "updateCursorPosition", "position", "updateCursorPosition-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CollaborationRepository {
    
    /**
     * Наблюдает за изменениями в заметке в реальном времени
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.notesapp.domain.entities.NoteChange> observeNoteChanges(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId);
    
    /**
     * Наблюдает за активными пользователями в заметке
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notesapp.domain.entities.ActiveUser>> observeActiveUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId);
    
    /**
     * Интерфейс репозитория для функций совместной работы
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}