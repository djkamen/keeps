package com.notesapp.domain.entities

/**
 * Статус синхронизации заметки
 */
enum class SyncStatus {
    SYNCED,     // Синхронизировано
    SYNCING,    // В процессе синхронизации
    PENDING,    // Ожидает синхронизации
    ERROR       // Ошибка синхронизации
}

/**
 * Информация об активном пользователе
 */
data class ActiveUser(
    val userId: String,
    val email: String,
    val displayName: String?,
    val cursorPosition: Int = 0,
    val lastActive: Long,
    val color: String = "#FF4CAF50"
)

/**
 * Изменение в заметке для real-time collaboration
 */
sealed class NoteChange {
    abstract val noteId: String
    abstract val userId: String
    abstract val timestamp: Long
    
    data class TextEdit(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val position: Int,
        val deletedLength: Int,
        val insertedText: String
    ) : NoteChange()
    
    data class ChecklistItemToggle(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val itemId: String,
        val isCompleted: Boolean
    ) : NoteChange()
    
    data class ChecklistItemAdd(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val item: ChecklistItem
    ) : NoteChange()
    
    data class ChecklistItemRemove(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val itemId: String
    ) : NoteChange()
    
    data class ColorChange(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val newColor: NoteColor
    ) : NoteChange()
    
    data class TitleChange(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long,
        val newTitle: String
    ) : NoteChange()
    
    data class NoteDeleted(
        override val noteId: String,
        override val userId: String,
        override val timestamp: Long
    ) : NoteChange()
}

/**
 * Метаданные заметок для синхронизации
 */
data class NotesMetadata(
    val notes: Map<String, NoteMetadata>,
    val lastSync: Long
)

data class NoteMetadata(
    val id: String,
    val lastModified: Long,
    val modifiedBy: String,
    val version: Int,
    val driveFileId: String?
)