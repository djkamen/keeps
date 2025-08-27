package com.notesapp.domain.usecases

import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import com.notesapp.domain.repositories.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для поиска заметок
 */
@Singleton
class SearchNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    /**
     * Ищет заметки по тексту
     */
    suspend operator fun invoke(query: String): Result<List<Note>> {
        return notesRepository.searchNotes(query)
    }
    
    /**
     * Получает заметки определенного цвета
     */
    suspend fun getNotesByColor(color: NoteColor): Result<List<Note>> {
        return notesRepository.getNotesByColor(color)
    }
}