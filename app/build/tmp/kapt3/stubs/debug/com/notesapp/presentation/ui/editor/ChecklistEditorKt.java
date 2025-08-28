package com.notesapp.presentation.ui.editor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001ab\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a<\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0014\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0015"}, d2 = {"AddNewItemButton", "", "onAddItem", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "ChecklistEditor", "items", "", "Lcom/notesapp/domain/entities/ChecklistItem;", "onItemChanged", "Lkotlin/Function2;", "", "onItemAdded", "onItemRemoved", "ChecklistItemEditor", "item", "onRemove", "Lkotlin/Function0;", "ChecklistProgress", "app_debug"})
public final class ChecklistEditorKt {
    
    /**
     * Checklist Editor Component with strikethrough for completed items
     */
    @androidx.compose.runtime.Composable()
    public static final void ChecklistEditor(@org.jetbrains.annotations.NotNull()
    java.util.List<com.notesapp.domain.entities.ChecklistItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.notesapp.domain.entities.ChecklistItem, kotlin.Unit> onItemChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.ChecklistItem, kotlin.Unit> onItemAdded, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemRemoved, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Individual checklist item editor
     */
    @androidx.compose.runtime.Composable()
    public static final void ChecklistItemEditor(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.ChecklistItem item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.ChecklistItem, kotlin.Unit> onItemChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRemove, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Button to add new checklist item
     */
    @androidx.compose.runtime.Composable()
    public static final void AddNewItemButton(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAddItem, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Helper composable to display checklist progress
     */
    @androidx.compose.runtime.Composable()
    public static final void ChecklistProgress(@org.jetbrains.annotations.NotNull()
    java.util.List<com.notesapp.domain.entities.ChecklistItem> items, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}