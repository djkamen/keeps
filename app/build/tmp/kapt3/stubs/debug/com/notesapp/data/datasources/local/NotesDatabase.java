package com.notesapp.data.datasources.local;

/**
 * Room база данных для приложения заметок
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/notesapp/data/datasources/local/NotesDatabase;", "Landroidx/room/RoomDatabase;", "()V", "notesDao", "Lcom/notesapp/data/datasources/local/NotesDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.notesapp.data.entities.NoteEntity.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "notes_database";
    @org.jetbrains.annotations.NotNull()
    public static final com.notesapp.data.datasources.local.NotesDatabase.Companion Companion = null;
    
    public NotesDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.notesapp.data.datasources.local.NotesDao notesDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/notesapp/data/datasources/local/NotesDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}