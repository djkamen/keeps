package com.notesapp.presentation.viewmodels;

/**
 * ViewModel для экрана списка заметок
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0013R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/notesapp/presentation/viewmodels/NotesListViewModel;", "Landroidx/lifecycle/ViewModel;", "getNotesUseCase", "Lcom/notesapp/domain/usecases/GetNotesUseCase;", "deleteNoteUseCase", "Lcom/notesapp/domain/usecases/DeleteNoteUseCase;", "syncNotesUseCase", "Lcom/notesapp/domain/usecases/SyncNotesUseCase;", "searchNotesUseCase", "Lcom/notesapp/domain/usecases/SearchNotesUseCase;", "(Lcom/notesapp/domain/usecases/GetNotesUseCase;Lcom/notesapp/domain/usecases/DeleteNoteUseCase;Lcom/notesapp/domain/usecases/SyncNotesUseCase;Lcom/notesapp/domain/usecases/SearchNotesUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notesapp/presentation/viewmodels/NotesListUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteNote", "", "noteId", "", "loadNotes", "refreshNotes", "searchNotes", "query", "syncNotes", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NotesListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.GetNotesUseCase getNotesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.DeleteNoteUseCase deleteNoteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.SyncNotesUseCase syncNotesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.SearchNotesUseCase searchNotesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notesapp.presentation.viewmodels.NotesListUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.NotesListUiState> uiState = null;
    
    @javax.inject.Inject()
    public NotesListViewModel(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.GetNotesUseCase getNotesUseCase, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.DeleteNoteUseCase deleteNoteUseCase, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.SyncNotesUseCase syncNotesUseCase, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.SearchNotesUseCase searchNotesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.NotesListUiState> getUiState() {
        return null;
    }
    
    /**
     * Загружает заметки
     */
    public final void loadNotes() {
    }
    
    /**
     * Удаляет заметку
     */
    public final void deleteNote(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId) {
    }
    
    /**
     * Обновляет заметки
     */
    public final void refreshNotes() {
    }
    
    /**
     * Поиск заметок
     */
    public final void searchNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * Синхронизирует заметки с облаком
     */
    public final void syncNotes() {
    }
}