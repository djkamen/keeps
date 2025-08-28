package com.notesapp.data.datasources.local;

/**
 * DAO для работы с заметками в Room базе данных
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rH\'J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0015\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ \u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u00a7@\u00a2\u0006\u0002\u0010#\u00a8\u0006$"}, d2 = {"Lcom/notesapp/data/datasources/local/NotesDao;", "", "deleteAllNotes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "note", "Lcom/notesapp/data/entities/NoteEntity;", "(Lcom/notesapp/data/entities/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noteId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "", "getNoteById", "getNotesByColor", "color", "Lcom/notesapp/domain/entities/NoteColor;", "(Lcom/notesapp/domain/entities/NoteColor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotesByType", "type", "getNotesCount", "", "getNotesNeedingSync", "insertNote", "searchNotes", "query", "updateDriveFileId", "driveFileId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "updateSyncStatus", "needsSync", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NotesDao {
    
    /**
     * Получает все заметки, отсортированные по времени обновления
     */
    @androidx.room.Query(value = "SELECT * FROM notes ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notesapp.data.entities.NoteEntity>> getAllNotes();
    
    /**
     * Получает заметку по ID
     */
    @androidx.room.Query(value = "SELECT * FROM notes WHERE id = :noteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNoteById(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.notesapp.data.entities.NoteEntity> $completion);
    
    /**
     * Вставляет или обновляет заметку
     */
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.entities.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Обновляет заметку
     */
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.entities.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Удаляет заметку по ID
     */
    @androidx.room.Query(value = "DELETE FROM notes WHERE id = :noteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Удаляет заметку
     */
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.entities.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Получает заметки, которые требуют синхронизации
     */
    @androidx.room.Query(value = "SELECT * FROM notes WHERE needsSync = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotesNeedingSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.notesapp.data.entities.NoteEntity>> $completion);
    
    /**
     * Ищет заметки по тексту в заголовке или содержимом
     */
    @androidx.room.Query(value = "SELECT * FROM notes WHERE title LIKE \'%\' || :query || \'%\' OR content LIKE \'%\' || :query || \'%\' ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.notesapp.data.entities.NoteEntity>> $completion);
    
    /**
     * Получает заметки определенного цвета
     */
    @androidx.room.Query(value = "SELECT * FROM notes WHERE color = :color ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotesByColor(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.notesapp.data.entities.NoteEntity>> $completion);
    
    /**
     * Получает заметки определенного типа
     */
    @androidx.room.Query(value = "SELECT * FROM notes WHERE contentType = :type ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotesByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.notesapp.data.entities.NoteEntity>> $completion);
    
    /**
     * Обновляет статус синхронизации заметки
     */
    @androidx.room.Query(value = "UPDATE notes SET needsSync = :needsSync WHERE id = :noteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSyncStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId, boolean needsSync, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Обновляет Drive file ID для заметки
     */
    @androidx.room.Query(value = "UPDATE notes SET driveFileId = :driveFileId WHERE id = :noteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDriveFileId(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId, @org.jetbrains.annotations.Nullable()
    java.lang.String driveFileId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Получает количество заметок
     */
    @androidx.room.Query(value = "SELECT COUNT(*) FROM notes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotesCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    /**
     * Удаляет все заметки
     */
    @androidx.room.Query(value = "DELETE FROM notes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllNotes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}