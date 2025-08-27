package com.notesapp.data.mappers

import com.google.gson.Gson
import com.notesapp.data.entities.NoteEntity
import com.notesapp.domain.entities.ChecklistItem
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteContent

/**
 * Маппер для преобразования между доменными моделями и data entities
 */
object NoteMapper {
    private val gson = Gson()
    
    /**
     * Преобразует доменную модель в data entity
     */
    fun toEntity(note: Note): NoteEntity {
        val (contentType, content) = when (note.content) {
            is NoteContent.Text -> "text" to note.content.content
            is NoteContent.Checklist -> "checklist" to gson.toJson(note.content.items)
        }
        
        return NoteEntity(
            id = note.id,
            title = note.title,
            contentType = contentType,
            content = content,
            color = note.color,
            createdAt = note.createdAt,
            updatedAt = note.updatedAt,
            lastEditedBy = note.lastEditedBy,
            isShared = note.isShared,
            needsSync = note.needsSync
        )
    }
    
    /**
     * Преобразует data entity в доменную модель
     */
    fun toDomain(entity: NoteEntity): Note {
        val noteContent = when (entity.contentType) {
            "text" -> NoteContent.Text(entity.content)
            "checklist" -> {
                val items = try {
                    gson.fromJson(entity.content, Array<ChecklistItem>::class.java).toList()
                } catch (e: Exception) {
                    emptyList<ChecklistItem>()
                }
                NoteContent.Checklist(items)
            }
            else -> NoteContent.Text(entity.content)
        }
        
        return Note(
            id = entity.id,
            title = entity.title,
            content = noteContent,
            color = entity.color,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt,
            lastEditedBy = entity.lastEditedBy,
            isShared = entity.isShared,
            needsSync = entity.needsSync
        )
    }
    
    /**
     * Преобразует список entities в список доменных моделей
     */
    fun toDomainList(entities: List<NoteEntity>): List<Note> {
        return entities.map { toDomain(it) }
    }
    
    /**
     * Преобразует список доменных моделей в список entities
     */
    fun toEntityList(notes: List<Note>): List<NoteEntity> {
        return notes.map { toEntity(it) }
    }
}