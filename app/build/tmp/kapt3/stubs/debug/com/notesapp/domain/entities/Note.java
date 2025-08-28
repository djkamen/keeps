package com.notesapp.domain.entities;

/**
 * Основная доменная модель заметки
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\nH\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u000eH\u00c6\u0003J\t\u0010&\u001a\u00020\u000eH\u00c6\u0003Jc\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\u0006\u0010-\u001a\u00020\u000eJ\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0003J\u0016\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0003R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016\u00a8\u00065"}, d2 = {"Lcom/notesapp/domain/entities/Note;", "", "id", "", "title", "content", "Lcom/notesapp/domain/entities/NoteContent;", "color", "Lcom/notesapp/domain/entities/NoteColor;", "createdAt", "", "updatedAt", "lastEditedBy", "isShared", "", "needsSync", "(Ljava/lang/String;Ljava/lang/String;Lcom/notesapp/domain/entities/NoteContent;Lcom/notesapp/domain/entities/NoteColor;JJLjava/lang/String;ZZ)V", "getColor", "()Lcom/notesapp/domain/entities/NoteColor;", "getContent", "()Lcom/notesapp/domain/entities/NoteContent;", "getCreatedAt", "()J", "getId", "()Ljava/lang/String;", "()Z", "getLastEditedBy", "getNeedsSync", "getTitle", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPreviewText", "hashCode", "", "isChecklist", "toString", "updateColor", "newColor", "userId", "updateContent", "newContent", "Companion", "app_debug"})
public final class Note {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.entities.NoteContent content = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.domain.entities.NoteColor color = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lastEditedBy = null;
    private final boolean isShared = false;
    private final boolean needsSync = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.notesapp.domain.entities.Note.Companion Companion = null;
    
    public Note(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteContent content, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color, long createdAt, long updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String lastEditedBy, boolean isShared, boolean needsSync) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.NoteContent getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.NoteColor getColor() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastEditedBy() {
        return null;
    }
    
    public final boolean isShared() {
        return false;
    }
    
    public final boolean getNeedsSync() {
        return false;
    }
    
    /**
     * Обновляет заметку с новым содержимым
     */
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.Note updateContent(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteContent newContent, @org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    /**
     * Обновляет цвет заметки
     */
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.Note updateColor(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor newColor, @org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    /**
     * Возвращает превью текста заметки для отображения в списке
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPreviewText() {
        return null;
    }
    
    /**
     * Проверяет, является ли заметка чек-листом
     */
    public final boolean isChecklist() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.NoteContent component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.NoteColor component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notesapp.domain.entities.Note copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteContent content, @org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color, long createdAt, long updatedAt, @org.jetbrains.annotations.NotNull()
    java.lang.String lastEditedBy, boolean isShared, boolean needsSync) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a8\u0006\u000f"}, d2 = {"Lcom/notesapp/domain/entities/Note$Companion;", "", "()V", "createChecklistNote", "Lcom/notesapp/domain/entities/Note;", "title", "", "items", "", "Lcom/notesapp/domain/entities/ChecklistItem;", "userId", "color", "Lcom/notesapp/domain/entities/NoteColor;", "createTextNote", "content", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Создает новую текстовую заметку
         */
        @org.jetbrains.annotations.NotNull()
        public final com.notesapp.domain.entities.Note createTextNote(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String content, @org.jetbrains.annotations.NotNull()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        com.notesapp.domain.entities.NoteColor color) {
            return null;
        }
        
        /**
         * Создает новую заметку-чеклист
         */
        @org.jetbrains.annotations.NotNull()
        public final com.notesapp.domain.entities.Note createChecklistNote(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.util.List<com.notesapp.domain.entities.ChecklistItem> items, @org.jetbrains.annotations.NotNull()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        com.notesapp.domain.entities.NoteColor color) {
            return null;
        }
    }
}