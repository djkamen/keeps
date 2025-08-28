package com.notesapp.presentation.viewmodels;

/**
 * ViewModel для экрана редактора заметок
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/notesapp/presentation/viewmodels/NoteEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "saveNoteUseCase", "Lcom/notesapp/domain/usecases/SaveNoteUseCase;", "getNoteUseCase", "Lcom/notesapp/domain/usecases/GetNoteUseCase;", "authRepository", "Lcom/notesapp/domain/repositories/AuthRepository;", "(Lcom/notesapp/domain/usecases/SaveNoteUseCase;Lcom/notesapp/domain/usecases/GetNoteUseCase;Lcom/notesapp/domain/repositories/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notesapp/presentation/viewmodels/NoteEditorUiState;", "originalNote", "Lcom/notesapp/domain/entities/Note;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "changeColor", "", "color", "Lcom/notesapp/domain/entities/NoteColor;", "hasChanges", "", "currentNote", "loadNote", "noteId", "", "saveNote", "updateContent", "content", "updateTitle", "title", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NoteEditorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.SaveNoteUseCase saveNoteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.usecases.GetNoteUseCase getNoteUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.repositories.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notesapp.presentation.viewmodels.NoteEditorUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.NoteEditorUiState> uiState = null;
    @org.jetbrains.annotations.Nullable()
    private com.notesapp.domain.entities.Note originalNote;
    
    @javax.inject.Inject()
    public NoteEditorViewModel(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.SaveNoteUseCase saveNoteUseCase, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.usecases.GetNoteUseCase getNoteUseCase, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.repositories.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notesapp.presentation.viewmodels.NoteEditorUiState> getUiState() {
        return null;
    }
    
    /**
     * Загружает заметку по ID или создает новую
     */
    public final void loadNote(@org.jetbrains.annotations.Nullable()
    java.lang.String noteId) {
    }
    
    /**
     * Обновляет заголовок заметки
     */
    public final void updateTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    /**
     * Обновляет содержимое заметки
     */
    public final void updateContent(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    /**
     * Меняет цвет заметки
     */
    public final void changeColor(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color) {
    }
    
    /**
     * Сохраняет заметку
     */
    public final void saveNote() {
    }
    
    /**
     * Проверяет, есть ли несохраненные изменения
     */
    private final boolean hasChanges(com.notesapp.domain.entities.Note currentNote) {
        return false;
    }
}