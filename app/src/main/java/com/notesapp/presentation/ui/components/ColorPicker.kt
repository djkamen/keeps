package com.notesapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.notesapp.domain.entities.NoteColor
import com.notesapp.presentation.ui.theme.NoteColors

/**
 * Color picker component for notes
 */
@Composable
fun ColorPicker(
    selectedColor: NoteColor,
    onColorSelected: (NoteColor) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    
    // Color picker trigger button
    OutlinedButton(
        onClick = { showDialog = true },
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Palette,
            contentDescription = "Выбрать цвет",
            modifier = Modifier.padding(end = 8.dp)
        )
        Text("Цвет")
        
        Spacer(modifier = Modifier.width(8.dp))
        
        // Current color indicator
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(NoteColors.fromNoteColor(selectedColor))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
        )
    }
    
    // Color picker dialog
    if (showDialog) {
        ColorPickerDialog(
            selectedColor = selectedColor,
            onColorSelected = { color ->
                onColorSelected(color)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}

/**
 * Color picker dialog
 */
@Composable
fun ColorPickerDialog(
    selectedColor: NoteColor,
    onColorSelected: (NoteColor) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Выберите цвет заметки",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Color grid
                ColorGrid(
                    selectedColor = selectedColor,
                    onColorSelected = onColorSelected
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Dialog buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Отмена")
                    }
                }
            }
        }
    }
}

/**
 * Grid of color options
 */
@Composable
fun ColorGrid(
    selectedColor: NoteColor,
    onColorSelected: (NoteColor) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = listOf(
        NoteColor.DEFAULT,
        NoteColor.YELLOW,
        NoteColor.GREEN,
        NoteColor.BLUE,
        NoteColor.RED,
        NoteColor.PURPLE,
        NoteColor.ORANGE
    )
    
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(colors) { color ->
            ColorOption(
                color = color,
                isSelected = color == selectedColor,
                onClick = { onColorSelected(color) }
            )
        }
    }
}

/**
 * Individual color option
 */
@Composable
fun ColorOption(
    color: NoteColor,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(NoteColors.fromNoteColor(color))
            .border(
                width = if (isSelected) 3.dp else 1.dp,
                color = if (isSelected) 
                    MaterialTheme.colorScheme.primary 
                else 
                    MaterialTheme.colorScheme.outline,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Выбрано",
                tint = if (color == NoteColor.DEFAULT) 
                    MaterialTheme.colorScheme.primary 
                else 
                    Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
    
    // Color name below the circle
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Text(
            text = color.displayName,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/**
 * Inline color picker for quick access
 */
@Composable
fun InlineColorPicker(
    selectedColor: NoteColor,
    onColorSelected: (NoteColor) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = listOf(
        NoteColor.DEFAULT,
        NoteColor.YELLOW,
        NoteColor.GREEN,
        NoteColor.BLUE,
        NoteColor.RED,
        NoteColor.PURPLE,
        NoteColor.ORANGE
    )
    
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "Цвет заметки",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(colors) { color ->
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(NoteColors.fromNoteColor(color))
                            .border(
                                width = if (color == selectedColor) 2.dp else 1.dp,
                                color = if (color == selectedColor) 
                                    MaterialTheme.colorScheme.primary 
                                else 
                                    MaterialTheme.colorScheme.outline,
                                shape = CircleShape
                            )
                            .clickable { onColorSelected(color) },
                        contentAlignment = Alignment.Center
                    ) {
                        if (color == selectedColor) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Выбрано",
                                tint = if (color == NoteColor.DEFAULT) 
                                    MaterialTheme.colorScheme.primary 
                                else 
                                    Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}