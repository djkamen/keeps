package com.notesapp.data.datasources.local

import androidx.room.*
import com.notesapp.data.entities.NoteEntity
import com.notesapp.domain.entities.NoteColor
import kotlinx.coroutines.flow.Flow

/**
 * DAO для работы с заметками в Room базе данных
 */
@Dao
interface NotesDao {
    
    /**
     * Получает все заметки, отсортированные по времени обновления
     */
    @Query("SELECT * FROM notes ORDER BY updatedAt DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>
    
    /**
     * Получает заметку по ID
     */
    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: String): NoteEntity?
    
    /**
     * Вставляет или обновляет заметку
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)
    
    /**
     * Обновляет заметку
     */
    @Update
    suspend fun updateNote(note: NoteEntity)
    
    /**
     * Удаляет заметку по ID
     */
    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNote(noteId: String)
    
    /**
     * Удаляет заметку
     */
    @Delete
    suspend fun deleteNote(note: NoteEntity)
    
    /**
     * Получает заметки, которые требуют синхронизации
     */
    @Query("SELECT * FROM notes WHERE needsSync = 1")
    suspend fun getNotesNeedingSync(): List<NoteEntity>
    
    /**
     * Ищет заметки по тексту в заголовке или содержимом
     */
    @Query("SELECT * FROM notes WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%' ORDER BY updatedAt DESC")
    suspend fun searchNotes(query: String): List<NoteEntity>
    
    /**
     * Получает заметки определенного цвета
     */
    @Query("SELECT * FROM notes WHERE color = :color ORDER BY updatedAt DESC")
    suspend fun getNotesByColor(color: NoteColor): List<NoteEntity>
    
    /**
     * Получает заметки определенного типа
     */
    @Query("SELECT * FROM notes WHERE contentType = :type ORDER BY updatedAt DESC")
    suspend fun getNotesByType(type: String): List<NoteEntity>
    
    /**
     * Обновляет статус синхронизации заметки
     */
    @Query("UPDATE notes SET needsSync = :needsSync WHERE id = :noteId")
    suspend fun updateSyncStatus(noteId: String, needsSync: Boolean)
    
    /**
     * Обновляет Drive file ID для заметки
     */
    @Query("UPDATE notes SET driveFileId = :driveFileId WHERE id = :noteId")
    suspend fun updateDriveFileId(noteId: String, driveFileId: String?)
    
    /**
     * Получает количество заметок
     */
    @Query("SELECT COUNT(*) FROM notes")
    suspend fun getNotesCount(): Int
    
    /**
     * Удаляет все заметки
     */
    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()
}