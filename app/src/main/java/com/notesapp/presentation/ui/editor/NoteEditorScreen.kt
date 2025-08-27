package com.notesapp.presentation.ui.editor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notesapp.domain.entities.ChecklistItem
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import com.notesapp.domain.entities.NoteContent
import com.notesapp.presentation.ui.components.ColorPicker
import com.notesapp.presentation.ui.components.InlineColorPicker

/**
 * Enhanced note editor screen that supports both text and checklist modes
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditorScreen(
    note: Note? = null,
    onNoteChanged: (Note) -> Unit = {},
    onSave: () -> Unit = {},
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var currentNote by remember { mutableStateOf(note) }
    
    LaunchedEffect(note) {
        currentNote = note
    }
    
    val isChecklist = currentNote?.isChecklist() == true

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = if (currentNote?.title?.isBlank() != false) "Новая заметка" else "Редактировать заметку"
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                },
                actions = {
                    // Toggle note type
                    IconButton(
                        onClick = {
                            currentNote?.let { note ->
                                val newContent = if (isChecklist) {
                                    // Convert checklist to text
                                    val text = when (note.content) {
                                        is NoteContent.Checklist -> {
                                            note.content.items.joinToString("\n") { item ->
                                                val prefix = if (item.isCompleted) "✓ " else "• "
                                                prefix + item.text
                                            }
                                        }
                                        else -> ""
                                    }
                                    NoteContent.Text(text)
                                } else {
                                    // Convert text to checklist
                                    val items = when (note.content) {
                                        is NoteContent.Text -> {
                                            note.content.content.split("\n")
                                                .filter { it.isNotBlank() }
                                                .mapIndexed { index, line ->
                                                    ChecklistItem.create(line.trim(), index)
                                                }
                                        }
                                        else -> emptyList()
                                    }
                                    NoteContent.Checklist(items)
                                }
                                
                                val updatedNote = note.copy(content = newContent)
                                currentNote = updatedNote
                                onNoteChanged(updatedNote)
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (isChecklist) Icons.Default.TextFields else Icons.Default.FormatListBulleted,
                            contentDescription = if (isChecklist) "Конвертировать в текст" else "Конвертировать в чек-лист"
                        )
                    }
                    
                    IconButton(
                        onClick = {
                            currentNote?.let { onNoteChanged(it) }
                            onSave()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Сохранить"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            currentNote?.let { note ->
                // Title field
                BasicTextField(
                    value = note.title,
                    onValueChange = { newTitle ->
                        val updatedNote = note.copy(title = newTitle)
                        currentNote = updatedNote
                        onNoteChanged(updatedNote)
                    },
                    textStyle = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    decorationBox = { innerTextField ->
                        if (note.title.isEmpty()) {
                            Text(
                                text = "Заголовок заметки",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                        innerTextField()
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Color picker
                InlineColorPicker(
                    selectedColor = note.color,
                    onColorSelected = { color ->
                        val updatedNote = note.copy(color = color)
                        currentNote = updatedNote
                        onNoteChanged(updatedNote)
                    }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Content editor based on type
                when (note.content) {
                    is NoteContent.Text -> {
                        TextNoteEditor(
                            content = note.content.content,
                            onContentChanged = { newContent ->
                                val updatedNote = note.copy(
                                    content = NoteContent.Text(newContent)
                                )
                                currentNote = updatedNote
                                onNoteChanged(updatedNote)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    is NoteContent.Checklist -> {
                        ChecklistEditor(
                            items = note.content.items,
                            onItemChanged = { index, item ->
                                val updatedItems = note.content.items.toMutableList()
                                updatedItems[index] = item
                                val updatedNote = note.copy(
                                    content = NoteContent.Checklist(updatedItems)
                                )
                                currentNote = updatedNote
                                onNoteChanged(updatedNote)
                            },
                            onItemAdded = { item ->
                                val updatedItems = note.content.items + item
                                val updatedNote = note.copy(
                                    content = NoteContent.Checklist(updatedItems)
                                )
                                currentNote = updatedNote
                                onNoteChanged(updatedNote)
                            },
                            onItemRemoved = { index ->
                                val updatedItems = note.content.items.toMutableList()
                                updatedItems.removeAt(index)
                                val updatedNote = note.copy(
                                    content = NoteContent.Checklist(updatedItems)
                                )
                                currentNote = updatedNote
                                onNoteChanged(updatedNote)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}