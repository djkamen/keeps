package com.notesapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.notesapp.domain.entities.ChecklistItem
import com.notesapp.domain.entities.NoteColor

/**
 * Room Entity для заметок
 */
@Entity(tableName = "notes")
@TypeConverters(NoteConverters::class)
data class NoteEntity(
    @PrimaryKey 
    val id: String,
    val title: String,
    val contentType: String, // "text" или "checklist"
    val content: String, // JSON для checklist или обычный текст
    val color: NoteColor,
    val createdAt: Long,
    val updatedAt: Long,
    val lastEditedBy: String,
    val isShared: Boolean,
    val needsSync: Boolean = false,
    val driveFileId: String? = null // ID файла в Google Drive
)

/**
 * Конвертеры типов для Room
 */
class NoteConverters {
    private val gson = Gson()
    
    @TypeConverter
    fun fromNoteColor(color: NoteColor): String {
        return color.name
    }
    
    @TypeConverter
    fun toNoteColor(colorName: String): NoteColor {
        return NoteColor.valueOf(colorName)
    }
    
    @TypeConverter
    fun fromChecklistItems(items: List<ChecklistItem>): String {
        return gson.toJson(items)
    }
    
    @TypeConverter
    fun toChecklistItems(itemsJson: String): List<ChecklistItem> {
        val type = object : TypeToken<List<ChecklistItem>>() {}.type
        return gson.fromJson(itemsJson, type) ?: emptyList()
    }
}