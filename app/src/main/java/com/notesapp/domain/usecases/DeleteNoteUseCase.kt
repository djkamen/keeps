package com.notesapp.domain.usecases

import com.notesapp.domain.entities.NoteChange
import com.notesapp.domain.repositories.CollaborationRepository
import com.notesapp.domain.repositories.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для удаления заметки
 */
@Singleton
class DeleteNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
    private val collaborationRepository: CollaborationRepository
) {
    /**
     * Удаляет заметку и уведомляет других пользователей
     */
    suspend operator fun invoke(noteId: String, userId: String): Result<Unit> {
        return try {
            // Удаляем заметку
            val deleteResult = notesRepository.deleteNote(noteId)
            if (deleteResult.isFailure) {
                return deleteResult
            }
            
            // Уведомляем других пользователей об удалении
            val change = NoteChange.NoteDeleted(
                noteId = noteId,
                userId = userId,
                timestamp = System.currentTimeMillis()
            )
            
            collaborationRepository.broadcastChange(change)
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}