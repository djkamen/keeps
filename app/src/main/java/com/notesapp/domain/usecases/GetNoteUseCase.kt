package com.notesapp.domain.usecases

import com.notesapp.domain.entities.Note
import com.notesapp.domain.repositories.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для получения заметки по ID
 */
@Singleton
class GetNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    /**
     * Получает заметку по ID
     */
    suspend operator fun invoke(noteId: String): Result<Note?> {
        return notesRepository.getNoteById(noteId)
    }
}