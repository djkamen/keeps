package com.notesapp.domain.usecases

import com.notesapp.domain.entities.Note
import com.notesapp.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use Case для получения списка заметок
 */
@Singleton
class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    /**
     * Получает все заметки как Flow для реактивных обновлений
     */
    operator fun invoke(): Flow<Result<List<Note>>> {
        return notesRepository.getNotes()
    }
}