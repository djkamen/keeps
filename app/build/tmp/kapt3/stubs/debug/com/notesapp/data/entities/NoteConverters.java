package com.notesapp.data.entities;

/**
 * Конвертеры типов для Room
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/notesapp/data/entities/NoteConverters;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromChecklistItems", "", "items", "", "Lcom/notesapp/domain/entities/ChecklistItem;", "fromNoteColor", "color", "Lcom/notesapp/domain/entities/NoteColor;", "toChecklistItems", "itemsJson", "toNoteColor", "colorName", "app_debug"})
public final class NoteConverters {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public NoteConverters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromNoteColor(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.NoteColor toNoteColor(@org.jetbrains.annotations.NotNull()
    java.lang.String colorName) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromChecklistItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.notesapp.domain.entities.ChecklistItem> items) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notesapp.domain.entities.ChecklistItem> toChecklistItems(@org.jetbrains.annotations.NotNull()
    java.lang.String itemsJson) {
        return null;
    }
}