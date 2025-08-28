package com.notesapp.data.repositories

import com.notesapp.data.datasources.local.NotesLocalDataSource
import com.notesapp.data.datasources.remote.GoogleDriveService
import com.notesapp.data.mappers.NoteMapper
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import com.notesapp.domain.entities.NotesMetadata
import com.notesapp.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of NotesRepository
 */
@Singleton
class NotesRepositoryImpl @Inject constructor(
    private val localDataSource: NotesLocalDataSource,
    private val googleDriveService: GoogleDriveService
) : NotesRepository {
    
    override fun getNotes(): Flow<Result<List<Note>>> {
        return localDataSource.getAllNotes().map { entities ->
            try {
                val notes = NoteMapper.toDomainList(entities)
                Result.success(notes)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
    
    override suspend fun getNoteById(noteId: String): Result<Note?> {
        return try {
            val entity = localDataSource.getNoteById(noteId)
            val note = entity?.let { NoteMapper.toDomain(it) }
            Result.success(note)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun saveNote(note: Note): Result<Unit> {
        return try {
            val entity = NoteMapper.toEntity(note)
            localDataSource.saveNote(entity)
            
            Log.d("NotesRepository", "Note saved locally: ${note.id}")
            
            // Попытаемся загрузить в Google Drive
            try {
                Log.d("NotesRepository", "Attempting to upload note to Google Drive: ${note.id}")
                val driveResult = googleDriveService.uploadNote(note)
                
                if (driveResult.isSuccess) {
                    val driveFileId = driveResult.getOrThrow()
                    Log.d("NotesRepository", "Successfully uploaded to Google Drive: $driveFileId")
                    // Обновляем запись с ID файла на Drive
                    val updatedEntity = entity.copy(driveFileId = driveFileId, needsSync = false)
                    localDataSource.saveNote(updatedEntity)
                } else {
                    Log.w("NotesRepository", "Failed to upload to Google Drive: ${driveResult.exceptionOrNull()?.message}")
                    // Если загрузка в Drive не удалась, помечаем как нужна синхронизация
                    val syncEntity = entity.copy(needsSync = true)
                    localDataSource.saveNote(syncEntity)
                }
            } catch (e: Exception) {
                Log.e("NotesRepository", "Exception during Google Drive upload", e)
                // Если загрузка в Drive не удалась, помечаем как нужна синхронизация
                val syncEntity = entity.copy(needsSync = true)
                localDataSource.saveNote(syncEntity)
            }
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteNote(noteId: String): Result<Unit> {
        return try {
            localDataSource.deleteNote(noteId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun uploadToCloud(note: Note): Result<String> {
        return try {
            val result = googleDriveService.uploadNote(note)
            if (result.isSuccess) {
                val driveFileId = result.getOrThrow()
                // Обновляем статус синхронизации
                localDataSource.updateSyncStatus(note.id, false)
                Result.success(driveFileId)
            } else {
                localDataSource.updateSyncStatus(note.id, true)
                result
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun downloadFromCloud(noteId: String, driveFileId: String): Result<Note> {
        // TODO: Implement Google Drive download
        return Result.failure(NotImplementedError("Google Drive download not implemented yet"))
    }
    
    override suspend fun syncNotes(): Result<Unit> {
        // TODO: Implement sync with Google Drive
        return try {
            // For now, just update sync status for all notes
            val notesNeedingSync = localDataSource.getNotesNeedingSync()
            notesNeedingSync.forEach { entity ->
                localDataSource.updateSyncStatus(entity.id, false)
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getMetadata(): Result<NotesMetadata> {
        // TODO: Implement metadata retrieval
        return try {
            val metadata = NotesMetadata(
                notes = emptyMap(),
                lastSync = System.currentTimeMillis()
            )
            Result.success(metadata)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun searchNotes(query: String): Result<List<Note>> {
        return try {
            val entities = localDataSource.searchNotes(query)
            val notes = NoteMapper.toDomainList(entities)
            Result.success(notes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getNotesByColor(color: NoteColor): Result<List<Note>> {
        return try {
            val entities = localDataSource.getNotesByColor(color)
            val notes = NoteMapper.toDomainList(entities)
            Result.success(notes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getNotesNeedingSync(): Result<List<Note>> {
        return try {
            val entities = localDataSource.getNotesNeedingSync()
            val notes = NoteMapper.toDomainList(entities)
            Result.success(notes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}