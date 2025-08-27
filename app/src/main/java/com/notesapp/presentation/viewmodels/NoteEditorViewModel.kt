package com.notesapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import com.notesapp.domain.entities.NoteContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Состояние UI для редактора заметок
 */
data class NoteEditorUiState(
    val note: Note? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val error: String? = null,
    val hasUnsavedChanges: Boolean = false
)

/**
 * ViewModel для экрана редактора заметок
 */
@HiltViewModel
class NoteEditorViewModel @Inject constructor(
    private val saveNoteUseCase: com.notesapp.domain.usecases.SaveNoteUseCase,
    private val getNoteUseCase: com.notesapp.domain.usecases.GetNoteUseCase,
    private val authRepository: com.notesapp.domain.repositories.AuthRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(NoteEditorUiState())
    val uiState: StateFlow<NoteEditorUiState> = _uiState.asStateFlow()
    
    private var originalNote: Note? = null
    
    /**
     * Загружает заметку по ID или создает новую
     */
    fun loadNote(noteId: String?) {
        viewModelScope.launch {
            if (noteId == null) {
                // Создаем новую заметку
                val currentUser = authRepository.getCurrentUser()
                val newNote = Note.createTextNote(
                    title = "",
                    content = "",
                    userId = currentUser?.id ?: "anonymous"
                )
                originalNote = newNote
                _uiState.value = _uiState.value.copy(note = newNote)
            } else {
                _uiState.value = _uiState.value.copy(isLoading = true)
                
                getNoteUseCase(noteId).fold(
                    onSuccess = { note ->
                        originalNote = note
                        _uiState.value = _uiState.value.copy(
                            note = note,
                            isLoading = false,
                            error = null
                        )
                    },
                    onFailure = { error ->
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = error.message
                        )
                    }
                )
            }
        }
    }
    
    /**
     * Обновляет заголовок заметки
     */
    fun updateTitle(title: String) {
        val currentNote = _uiState.value.note ?: return
        val updatedNote = currentNote.copy(
            title = title,
            updatedAt = System.currentTimeMillis()
        )
        
        _uiState.value = _uiState.value.copy(
            note = updatedNote,
            hasUnsavedChanges = hasChanges(updatedNote)
        )
    }
    
    /**
     * Обновляет содержимое заметки
     */
    fun updateContent(content: String) {
        val currentNote = _uiState.value.note ?: return
        val updatedContent = when (currentNote.content) {
            is NoteContent.Text -> NoteContent.Text(content)
            is NoteContent.Checklist -> currentNote.content // Для чек-листов отдельная логика
        }
        
        val updatedNote = currentNote.copy(
            content = updatedContent,
            updatedAt = System.currentTimeMillis()
        )
        
        _uiState.value = _uiState.value.copy(
            note = updatedNote,
            hasUnsavedChanges = hasChanges(updatedNote)
        )
    }
    
    /**
     * Меняет цвет заметки
     */
    fun changeColor(color: NoteColor) {
        viewModelScope.launch {
            val currentNote = _uiState.value.note ?: return@launch
            val currentUser = authRepository.getCurrentUser()
            val updatedNote = currentNote.updateColor(color, currentUser?.id ?: "anonymous")
            
            _uiState.value = _uiState.value.copy(
                note = updatedNote,
                hasUnsavedChanges = hasChanges(updatedNote)
            )
        }
    }
    
    /**
     * Сохраняет заметку
     */
    fun saveNote() {
        val note = _uiState.value.note ?: return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isSaving = true)
            
            saveNoteUseCase(note).fold(
                onSuccess = {
                    originalNote = note
                    _uiState.value = _uiState.value.copy(
                        isSaving = false,
                        hasUnsavedChanges = false,
                        error = null
                    )
                },
                onFailure = { error ->
                    _uiState.value = _uiState.value.copy(
                        isSaving = false,
                        error = error.message
                    )
                }
            )
        }
    }
    
    /**
     * Проверяет, есть ли несохраненные изменения
     */
    private fun hasChanges(currentNote: Note): Boolean {
        val original = originalNote ?: return true
        return original.title != currentNote.title ||
                original.content != currentNote.content ||
                original.color != currentNote.color
    }
}