package com.notesapp.domain.repositories

import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NotesMetadata
import kotlinx.coroutines.flow.Flow

/**
 * Интерфейс репозитория для работы с заметками
 */
interface NotesRepository {
    
    /**
     * Получает все заметки как Flow для реактивных обновлений
     */
    fun getNotes(): Flow<Result<List<Note>>>
    
    /**
     * Получает заметку по ID
     */
    suspend fun getNoteById(noteId: String): Result<Note?>
    
    /**
     * Сохраняет заметку локально
     */
    suspend fun saveNote(note: Note): Result<Unit>
    
    /**
     * Удаляет заметку
     */
    suspend fun deleteNote(noteId: String): Result<Unit>
    
    /**
     * Загружает заметку в облако (Google Drive)
     */
    suspend fun uploadToCloud(note: Note): Result<String>
    
    /**
     * Загружает заметку из облака
     */
    suspend fun downloadFromCloud(noteId: String, driveFileId: String): Result<Note>
    
    /**
     * Синхронизирует заметки с облаком
     */
    suspend fun syncNotes(): Result<Unit>
    
    /**
     * Получает метаданные заметок
     */
    suspend fun getMetadata(): Result<NotesMetadata>
    
    /**
     * Поиск заметок по тексту
     */
    suspend fun searchNotes(query: String): Result<List<Note>>
    
    /**
     * Получает заметки определенного цвета
     */
    suspend fun getNotesByColor(color: com.notesapp.domain.entities.NoteColor): Result<List<Note>>
    
    /**
     * Получает заметки, которые нужно синхронизировать
     */
    suspend fun getNotesNeedingSync(): Result<List<Note>>
}