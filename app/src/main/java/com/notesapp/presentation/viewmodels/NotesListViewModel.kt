package com.notesapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.SyncStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Состояние UI для списка заметок
 */
data class NotesListUiState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val syncStatus: SyncStatus = SyncStatus.SYNCED,
    val searchQuery: String = ""
)

/**
 * ViewModel для экрана списка заметок
 */
@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val getNotesUseCase: com.notesapp.domain.usecases.GetNotesUseCase,
    private val deleteNoteUseCase: com.notesapp.domain.usecases.DeleteNoteUseCase,
    private val syncNotesUseCase: com.notesapp.domain.usecases.SyncNotesUseCase,
    private val searchNotesUseCase: com.notesapp.domain.usecases.SearchNotesUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(NotesListUiState())
    val uiState: StateFlow<NotesListUiState> = _uiState.asStateFlow()
    
    init {
        loadNotes()
    }
    
    /**
     * Загружает заметки
     */
    fun loadNotes() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            getNotesUseCase().collect { result ->
                result.fold(
                    onSuccess = { notes ->
                        _uiState.value = _uiState.value.copy(
                            notes = notes,
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
     * Удаляет заметку
     */
    fun deleteNote(noteId: String) {
        viewModelScope.launch {
            deleteNoteUseCase(noteId, "current_user").fold(
                onSuccess = {
                    // Успешно удалено, заметки обновятся через Flow
                },
                onFailure = { error ->
                    _uiState.value = _uiState.value.copy(error = error.message)
                }
            )
        }
    }
    
    /**
     * Обновляет заметки
     */
    fun refreshNotes() {
        loadNotes()
    }
    
    /**
     * Поиск заметок
     */
    fun searchNotes(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        
        if (query.isBlank()) {
            loadNotes()
            return
        }
        
        viewModelScope.launch {
            searchNotesUseCase(query).fold(
                onSuccess = { notes ->
                    _uiState.value = _uiState.value.copy(
                        notes = notes,
                        error = null
                    )
                },
                onFailure = { error ->
                    _uiState.value = _uiState.value.copy(error = error.message)
                }
            )
        }
    }
    
    /**
     * Синхронизирует заметки с облаком
     */
    fun syncNotes() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(syncStatus = SyncStatus.SYNCING)
            
            syncNotesUseCase().fold(
                onSuccess = {
                    _uiState.value = _uiState.value.copy(syncStatus = SyncStatus.SYNCED)
                },
                onFailure = {
                    _uiState.value = _uiState.value.copy(syncStatus = SyncStatus.ERROR)
                }
            )
        }
    }
}