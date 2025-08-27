package com.notesapp.domain.usecases

import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteChange
import com.notesapp.domain.repositories.CollaborationRepository
import com.notesapp.domain.repositories.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для сохранения заметки
 */
@Singleton
class SaveNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository,
    private val collaborationRepository: CollaborationRepository
) {
    /**
     * Сохраняет заметку локально и синхронизирует с облаком
     */
    suspend operator fun invoke(note: Note): Result<Unit> {
        return try {
            // Сохраняем локально
            val saveResult = notesRepository.saveNote(note)
            if (saveResult.isFailure) {
                return saveResult
            }
            
            // Загружаем в облако
            val uploadResult = notesRepository.uploadToCloud(note)
            if (uploadResult.isFailure) {
                // Помечаем как требующую синхронизации
                val noteNeedingSync = note.copy(needsSync = true)
                notesRepository.saveNote(noteNeedingSync)
            }
            
            // Уведомляем других пользователей об изменении
            val change = when (note.content) {
                is com.notesapp.domain.entities.NoteContent.Text -> {
                    NoteChange.TextEdit(
                        noteId = note.id,
                        userId = note.lastEditedBy,
                        timestamp = note.updatedAt,
                        position = 0,
                        deletedLength = 0,
                        insertedText = note.content.content
                    )
                }
                is com.notesapp.domain.entities.NoteContent.Checklist -> {
                    // Для чек-листа отправляем уведомление о обновлении всего списка
                    NoteChange.TitleChange(
                        noteId = note.id,
                        userId = note.lastEditedBy,
                        timestamp = note.updatedAt,
                        newTitle = note.title
                    )
                }
            }
            
            collaborationRepository.broadcastChange(change)
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}