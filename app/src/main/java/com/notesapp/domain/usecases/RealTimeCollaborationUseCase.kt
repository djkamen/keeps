package com.notesapp.domain.usecases

import com.notesapp.domain.entities.ActiveUser
import com.notesapp.domain.entities.NoteChange
import com.notesapp.domain.repositories.CollaborationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для совместной работы в реальном времени
 */
@Singleton
class RealTimeCollaborationUseCase @Inject constructor(
    private val collaborationRepository: CollaborationRepository
) {
    /**
     * Наблюдает за изменениями в заметке
     */
    fun observeNoteChanges(noteId: String): Flow<NoteChange> {
        return collaborationRepository.observeNoteChanges(noteId)
    }
    
    /**
     * Наблюдает за активными пользователями
     */
    fun observeActiveUsers(noteId: String): Flow<List<ActiveUser>> {
        return collaborationRepository.observeActiveUsers(noteId)
    }
    
    /**
     * Присоединяется к совместному редактированию заметки
     */
    suspend fun joinNote(noteId: String, user: ActiveUser): Result<Unit> {
        return collaborationRepository.joinNote(noteId, user)
    }
    
    /**
     * Покидает совместное редактирование заметки
     */
    suspend fun leaveNote(noteId: String, userId: String): Result<Unit> {
        return collaborationRepository.leaveNote(noteId, userId)
    }
    
    /**
     * Отправляет изменение другим пользователям
     */
    suspend fun broadcastChange(change: NoteChange): Result<Unit> {
        return collaborationRepository.broadcastChange(change)
    }
    
    /**
     * Обновляет позицию курсора
     */
    suspend fun updateCursorPosition(noteId: String, userId: String, position: Int): Result<Unit> {
        return collaborationRepository.updateCursorPosition(noteId, userId, position)
    }
}