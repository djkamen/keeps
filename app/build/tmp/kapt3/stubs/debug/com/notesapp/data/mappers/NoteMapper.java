package com.notesapp.data.mappers;

/**
 * Маппер для преобразования между доменными моделями и data entities
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/notesapp/data/mappers/NoteMapper;", "", "()V", "gson", "Lcom/google/gson/Gson;", "toDomain", "Lcom/notesapp/domain/entities/Note;", "entity", "Lcom/notesapp/data/entities/NoteEntity;", "toDomainList", "", "entities", "toEntity", "note", "toEntityList", "notes", "app_debug"})
public final class NoteMapper {
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.notesapp.data.mappers.NoteMapper INSTANCE = null;
    
    private NoteMapper() {
        super();
    }
    
    /**
     * Преобразует доменную модель в data entity
     */
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.data.entities.NoteEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.Note note) {
        return null;
    }
    
    /**
     * Преобразует data entity в доменную модель
     */
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.Note toDomain(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.entities.NoteEntity entity) {
        return null;
    }
    
    /**
     * Преобразует список entities в список доменных моделей
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notesapp.domain.entities.Note> toDomainList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.notesapp.data.entities.NoteEntity> entities) {
        return null;
    }
    
    /**
     * Преобразует список доменных моделей в список entities
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notesapp.data.entities.NoteEntity> toEntityList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.notesapp.domain.entities.Note> notes) {
        return null;
    }
}