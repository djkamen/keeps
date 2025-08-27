package com.notesapp.domain.entities

/**
 * Основная доменная модель заметки
 */
data class Note(
    val id: String,
    val title: String,
    val content: NoteContent,
    val color: NoteColor = NoteColor.DEFAULT,
    val createdAt: Long,
    val updatedAt: Long,
    val lastEditedBy: String,
    val isShared: Boolean = false,
    val needsSync: Boolean = false
) {
    companion object {
        /**
         * Создает новую текстовую заметку
         */
        fun createTextNote(
            title: String,
            content: String,
            userId: String,
            color: NoteColor = NoteColor.DEFAULT
        ): Note {
            val currentTime = System.currentTimeMillis()
            return Note(
                id = java.util.UUID.randomUUID().toString(),
                title = title,
                content = NoteContent.Text(content),
                color = color,
                createdAt = currentTime,
                updatedAt = currentTime,
                lastEditedBy = userId,
                isShared = false,
                needsSync = true
            )
        }
        
        /**
         * Создает новую заметку-чеклист
         */
        fun createChecklistNote(
            title: String,
            items: List<ChecklistItem>,
            userId: String,
            color: NoteColor = NoteColor.DEFAULT
        ): Note {
            val currentTime = System.currentTimeMillis()
            return Note(
                id = java.util.UUID.randomUUID().toString(),
                title = title,
                content = NoteContent.Checklist(items),
                color = color,
                createdAt = currentTime,
                updatedAt = currentTime,
                lastEditedBy = userId,
                isShared = false,
                needsSync = true
            )
        }
    }
    
    /**
     * Обновляет заметку с новым содержимым
     */
    fun updateContent(newContent: NoteContent, userId: String): Note {
        return this.copy(
            content = newContent,
            updatedAt = System.currentTimeMillis(),
            lastEditedBy = userId,
            needsSync = true
        )
    }
    
    /**
     * Обновляет цвет заметки
     */
    fun updateColor(newColor: NoteColor, userId: String): Note {
        return this.copy(
            color = newColor,
            updatedAt = System.currentTimeMillis(),
            lastEditedBy = userId,
            needsSync = true
        )
    }
    
    /**
     * Возвращает превью текста заметки для отображения в списке
     */
    fun getPreviewText(): String {
        return when (content) {
            is NoteContent.Text -> content.content.take(100)
            is NoteContent.Checklist -> {
                val completedCount = content.items.count { it.isCompleted }
                val totalCount = content.items.size
                "Чек-лист: $completedCount/$totalCount выполнено"
            }
        }
    }
    
    /**
     * Проверяет, является ли заметка чек-листом
     */
    fun isChecklist(): Boolean = content is NoteContent.Checklist
}