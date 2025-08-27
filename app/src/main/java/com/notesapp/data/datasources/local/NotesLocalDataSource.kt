package com.notesapp.data.datasources.local

import com.notesapp.data.entities.NoteEntity
import com.notesapp.domain.entities.NoteColor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Интерфейс локального источника данных
 */
interface NotesLocalDataSource {
    fun getAllNotes(): Flow<List<NoteEntity>>
    suspend fun getNoteById(noteId: String): NoteEntity?
    suspend fun saveNote(note: NoteEntity)
    suspend fun deleteNote(noteId: String)
    suspend fun getNotesNeedingSync(): List<NoteEntity>
    suspend fun searchNotes(query: String): List<NoteEntity>
    suspend fun getNotesByColor(color: NoteColor): List<NoteEntity>
    suspend fun updateSyncStatus(noteId: String, needsSync: Boolean)
    suspend fun updateDriveFileId(noteId: String, driveFileId: String?)
}

/**
 * Реализация локального источника данных с Room
 */
@Singleton
class NotesLocalDataSourceImpl @Inject constructor(
    private val notesDao: NotesDao
) : NotesLocalDataSource {
    
    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return notesDao.getAllNotes()
    }
    
    override suspend fun getNoteById(noteId: String): NoteEntity? {
        return notesDao.getNoteById(noteId)
    }
    
    override suspend fun saveNote(note: NoteEntity) {
        notesDao.insertNote(note)
    }
    
    override suspend fun deleteNote(noteId: String) {
        notesDao.deleteNote(noteId)
    }
    
    override suspend fun getNotesNeedingSync(): List<NoteEntity> {
        return notesDao.getNotesNeedingSync()
    }
    
    override suspend fun searchNotes(query: String): List<NoteEntity> {
        return notesDao.searchNotes(query)
    }
    
    override suspend fun getNotesByColor(color: NoteColor): List<NoteEntity> {
        return notesDao.getNotesByColor(color)
    }
    
    override suspend fun updateSyncStatus(noteId: String, needsSync: Boolean) {
        notesDao.updateSyncStatus(noteId, needsSync)
    }
    
    override suspend fun updateDriveFileId(noteId: String, driveFileId: String?) {
        notesDao.updateDriveFileId(noteId, driveFileId)
    }
}