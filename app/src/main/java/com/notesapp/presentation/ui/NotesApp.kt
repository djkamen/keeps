package com.notesapp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.notesapp.presentation.ui.editor.NoteEditorScreen
import com.notesapp.presentation.ui.notes.NotesListScreen
import com.notesapp.presentation.viewmodels.NoteEditorViewModel
import com.notesapp.presentation.viewmodels.NotesListViewModel

/**
 * Маршруты навигации
 */
object Routes {
    const val NOTES_LIST = "notes_list"
    const val NOTE_EDITOR = "note_editor"
    const val NOTE_EDITOR_WITH_ID = "note_editor/{noteId}"
}

/**
 * Главный компонент приложения с навигацией
 */
@Composable
fun NotesApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.NOTES_LIST
    ) {
        // Экран списка заметок
        composable(Routes.NOTES_LIST) {
            val viewModel: NotesListViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            
            NotesListScreen(
                notes = uiState.notes,
                onNoteClick = { noteId ->
                    navController.navigate("note_editor/$noteId")
                },
                onCreateNote = {
                    navController.navigate(Routes.NOTE_EDITOR)
                }
            )
        }
        
        // Экран редактора заметок (новая заметка)
        composable(Routes.NOTE_EDITOR) {
            val viewModel: NoteEditorViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            
            // Initialize with empty note if not loaded
            LaunchedEffect(Unit) {
                viewModel.loadNote(null)
            }
            
            NoteEditorScreen(
                note = uiState.note,
                onNoteChanged = { note ->
                    // Update individual fields based on what changed
                    uiState.note?.let { currentNote ->
                        if (currentNote.title != note.title) {
                            viewModel.updateTitle(note.title)
                        }
                        if (currentNote.content != note.content) {
                            when (note.content) {
                                is com.notesapp.domain.entities.NoteContent.Text -> {
                                    viewModel.updateContent(note.content.content)
                                }
                                else -> {
                                    // Handle checklist updates through the note itself
                                    // This is a simplified approach
                                }
                            }
                        }
                        if (currentNote.color != note.color) {
                            viewModel.changeColor(note.color)
                        }
                    }
                },
                onSave = {
                    viewModel.saveNote()
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        
        // Экран редактора заметок (редактирование существующей)
        composable(Routes.NOTE_EDITOR_WITH_ID) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            val viewModel: NoteEditorViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            
            // Загружаем заметку при первом открытии
            LaunchedEffect(noteId) {
                viewModel.loadNote(noteId)
            }
            
            NoteEditorScreen(
                note = uiState.note,
                onNoteChanged = { note ->
                    // Update individual fields based on what changed
                    uiState.note?.let { currentNote ->
                        if (currentNote.title != note.title) {
                            viewModel.updateTitle(note.title)
                        }
                        if (currentNote.content != note.content) {
                            when (note.content) {
                                is com.notesapp.domain.entities.NoteContent.Text -> {
                                    viewModel.updateContent(note.content.content)
                                }
                                else -> {
                                    // Handle checklist updates
                                }
                            }
                        }
                        if (currentNote.color != note.color) {
                            viewModel.changeColor(note.color)
                        }
                    }
                },
                onSave = {
                    viewModel.saveNote()
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}