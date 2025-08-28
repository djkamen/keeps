package com.notesapp.domain.usecases;

/**
 * Use Case для удаления заметки
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086B\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000f"}, d2 = {"Lcom/notesapp/domain/usecases/DeleteNoteUseCase;", "", "notesRepository", "Lcom/notesapp/domain/repositories/NotesRepository;", "collaborationRepository", "Lcom/notesapp/domain/repositories/CollaborationRepository;", "(Lcom/notesapp/domain/repositories/NotesRepository;Lcom/notesapp/domain/repositories/CollaborationRepository;)V", "invoke", "Lkotlin/Result;", "", "noteId", "", "userId", "invoke-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DeleteNoteUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.repositories.NotesRepository notesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.repositories.CollaborationRepository collaborationRepository = null;
    
    @javax.inject.Inject()
    public DeleteNoteUseCase(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.repositories.NotesRepository notesRepository, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.repositories.CollaborationRepository collaborationRepository) {
        super();
    }
}