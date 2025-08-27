package com.notesapp.domain.entities

/**
 * Sealed класс для различных типов содержимого заметок
 */
sealed class NoteContent {
    /**
     * Текстовое содержимое заметки
     */
    data class Text(val content: String) : NoteContent()
    
    /**
     * Содержимое в виде чек-листа
     */
    data class Checklist(val items: List<ChecklistItem>) : NoteContent()
}

/**
 * Элемент чек-листа
 */
data class ChecklistItem(
    val id: String,
    val text: String,
    val isCompleted: Boolean,
    val order: Int
) {
    companion object {
        fun create(text: String, order: Int): ChecklistItem {
            return ChecklistItem(
                id = java.util.UUID.randomUUID().toString(),
                text = text,
                isCompleted = false,
                order = order
            )
        }
    }
}