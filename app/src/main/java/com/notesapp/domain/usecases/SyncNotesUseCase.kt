package com.notesapp.domain.usecases

import com.notesapp.domain.repositories.NotesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для синхронизации заметок с облаком
 */
@Singleton
class SyncNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    /**
     * Синхронизирует заметки с Google Drive
     */
    suspend operator fun invoke(): Result<Unit> {
        return notesRepository.syncNotes()
    }
    
    /**
     * Получает заметки, которые нужно синхронизировать
     */
    suspend fun getNotesNeedingSync(): Result<List<com.notesapp.domain.entities.Note>> {
        return notesRepository.getNotesNeedingSync()
    }
}