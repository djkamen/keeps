package com.notesapp.domain.usecases;

/**
 * Use Case для получения списка заметок
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/notesapp/domain/usecases/GetNotesUseCase;", "", "notesRepository", "Lcom/notesapp/domain/repositories/NotesRepository;", "(Lcom/notesapp/domain/repositories/NotesRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "Lcom/notesapp/domain/entities/Note;", "app_debug"})
public final class GetNotesUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.repositories.NotesRepository notesRepository = null;
    
    @javax.inject.Inject()
    public GetNotesUseCase(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.repositories.NotesRepository notesRepository) {
        super();
    }
    
    /**
     * Получает все заметки как Flow для реактивных обновлений
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.notesapp.domain.entities.Note>>> invoke() {
        return null;
    }
}