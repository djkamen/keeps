package com.notesapp.domain.repositories

import com.notesapp.domain.entities.ActiveUser
import com.notesapp.domain.entities.NoteChange
import kotlinx.coroutines.flow.Flow

/**
 * Интерфейс репозитория для функций совместной работы
 */
interface CollaborationRepository {
    
    /**
     * Наблюдает за изменениями в заметке в реальном времени
     */
    fun observeNoteChanges(noteId: String): Flow<NoteChange>
    
    /**
     * Отправляет изменение в заметке другим пользователям
     */
    suspend fun broadcastChange(change: NoteChange): Result<Unit>
    
    /**
     * Наблюдает за активными пользователями в заметке
     */
    fun observeActiveUsers(noteId: String): Flow<List<ActiveUser>>
    
    /**
     * Регистрирует текущего пользователя как активного в заметке
     */
    suspend fun joinNote(noteId: String, user: ActiveUser): Result<Unit>
    
    /**
     * Убирает текущего пользователя из активных в заметке
     */
    suspend fun leaveNote(noteId: String, userId: String): Result<Unit>
    
    /**
     * Обновляет позицию курсора пользователя
     */
    suspend fun updateCursorPosition(noteId: String, userId: String, position: Int): Result<Unit>
    
    /**
     * Получает историю изменений заметки
     */
    suspend fun getChangeHistory(noteId: String, limit: Int = 50): Result<List<NoteChange>>
}