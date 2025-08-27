package com.notesapp.data.repositories

import com.notesapp.data.datasources.local.NotesLocalDataSource
import com.notesapp.data.entities.NoteEntity
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for NotesRepositoryImpl
 */
class NotesRepositoryImplTest {
    
    private lateinit var repository: NotesRepositoryImpl
    private val mockLocalDataSource = mockk<NotesLocalDataSource>()
    
    @Before
    fun setup() {
        repository = NotesRepositoryImpl(mockLocalDataSource)
    }
    
    @Test
    fun `getNotes should return success when local data source succeeds`() = runTest {
        // Given
        val testEntities = listOf(
            NoteEntity(
                id = "1",
                title = "Test Note",
                contentType = "text",
                content = "Test content",
                color = NoteColor.DEFAULT,
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis(),
                lastEditedBy = "test_user",
                isShared = false
            )
        )
        coEvery { mockLocalDataSource.getAllNotes() } returns flowOf(testEntities)
        
        // When
        val result = repository.getNotes().first()
        
        // Then
        assertTrue(result.isSuccess)
        assertEquals(1, result.getOrNull()?.size)
        assertEquals("Test Note", result.getOrNull()?.first()?.title)
    }
    
    @Test
    fun `saveNote should call local data source`() = runTest {
        // Given
        val testNote = Note.createTextNote(
            title = "Test",
            content = "Content",
            userId = "user"
        )
        coEvery { mockLocalDataSource.saveNote(any()) } returns Unit
        
        // When
        val result = repository.saveNote(testNote)
        
        // Then
        assertTrue(result.isSuccess)
        coVerify { mockLocalDataSource.saveNote(any()) }
    }
}