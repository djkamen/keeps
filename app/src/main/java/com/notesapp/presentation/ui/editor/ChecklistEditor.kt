package com.notesapp.presentation.ui.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notesapp.domain.entities.ChecklistItem

/**
 * Checklist Editor Component with strikethrough for completed items
 */
@Composable
fun ChecklistEditor(
    items: List<ChecklistItem>,
    onItemChanged: (Int, ChecklistItem) -> Unit,
    onItemAdded: (ChecklistItem) -> Unit,
    onItemRemoved: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Existing checklist items
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items) { index, item ->
                ChecklistItemEditor(
                    item = item,
                    onItemChanged = { updatedItem ->
                        onItemChanged(index, updatedItem)
                    },
                    onRemove = {
                        onItemRemoved(index)
                    }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Add new item button
        AddNewItemButton(
            onAddItem = { text ->
                val newItem = ChecklistItem.create(text, items.size)
                onItemAdded(newItem)
            }
        )
    }
}

/**
 * Individual checklist item editor
 */
@Composable
fun ChecklistItemEditor(
    item: ChecklistItem,
    onItemChanged: (ChecklistItem) -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isCompleted) 
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            else 
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox
            Checkbox(
                checked = item.isCompleted,
                onCheckedChange = { isChecked ->
                    onItemChanged(item.copy(isCompleted = isChecked))
                },
                modifier = Modifier.padding(end = 12.dp)
            )
            
            // Text field
            BasicTextField(
                value = item.text,
                onValueChange = { newText ->
                    onItemChanged(item.copy(text = newText))
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = if (item.isCompleted) 
                        MaterialTheme.colorScheme.onSurfaceVariant
                    else 
                        MaterialTheme.colorScheme.onSurface,
                    textDecoration = if (item.isCompleted) 
                        TextDecoration.LineThrough 
                    else 
                        TextDecoration.None
                ),
                decorationBox = { innerTextField ->
                    if (item.text.isEmpty()) {
                        Text(
                            text = "Введите пункт списка...",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                    innerTextField()
                },
                modifier = Modifier.weight(1f)
            )
            
            // Delete button
            IconButton(
                onClick = onRemove,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Удалить пункт",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

/**
 * Button to add new checklist item
 */
@Composable
fun AddNewItemButton(
    onAddItem: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var newItemText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    
    if (isExpanded) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = newItemText,
                    onValueChange = { newItemText = it },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    decorationBox = { innerTextField ->
                        if (newItemText.isEmpty()) {
                            Text(
                                text = "Новый пункт списка",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                        innerTextField()
                    },
                    modifier = Modifier.weight(1f)
                )
                
                Row {
                    // Cancel button
                    TextButton(
                        onClick = {
                            newItemText = ""
                            isExpanded = false
                        }
                    ) {
                        Text("Отмена")
                    }
                    
                    // Add button
                    TextButton(
                        onClick = {
                            if (newItemText.isNotBlank()) {
                                onAddItem(newItemText.trim())
                                newItemText = ""
                                isExpanded = false
                            }
                        }
                    ) {
                        Text("Добавить")
                    }
                }
            }
        }
    } else {
        // Collapsed add button
        OutlinedButton(
            onClick = { isExpanded = true },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Добавить пункт",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Добавить пункт")
        }
    }
}

/**
 * Helper composable to display checklist progress
 */
@Composable
fun ChecklistProgress(
    items: List<ChecklistItem>,
    modifier: Modifier = Modifier
) {
    val completedCount = items.count { it.isCompleted }
    val totalCount = items.size
    val progress = if (totalCount > 0) completedCount.toFloat() / totalCount else 0f
    
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Прогресс",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "$completedCount/$totalCount",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(2.dp)),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}