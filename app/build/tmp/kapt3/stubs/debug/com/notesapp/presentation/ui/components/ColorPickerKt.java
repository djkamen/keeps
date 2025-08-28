package com.notesapp.presentation.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a0\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a.\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a2\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a.\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\u0012"}, d2 = {"ColorGrid", "", "selectedColor", "Lcom/notesapp/domain/entities/NoteColor;", "onColorSelected", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "ColorOption", "color", "isSelected", "", "onClick", "Lkotlin/Function0;", "ColorPicker", "ColorPickerDialog", "onDismiss", "InlineColorPicker", "app_debug"})
public final class ColorPickerKt {
    
    /**
     * Color picker component for notes
     */
    @androidx.compose.runtime.Composable()
    public static final void ColorPicker(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor selectedColor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.NoteColor, kotlin.Unit> onColorSelected, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Color picker dialog
     */
    @androidx.compose.runtime.Composable()
    public static final void ColorPickerDialog(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor selectedColor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.NoteColor, kotlin.Unit> onColorSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    /**
     * Grid of color options
     */
    @androidx.compose.runtime.Composable()
    public static final void ColorGrid(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor selectedColor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.NoteColor, kotlin.Unit> onColorSelected, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Individual color option
     */
    @androidx.compose.runtime.Composable()
    public static final void ColorOption(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor color, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Inline color picker for quick access
     */
    @androidx.compose.runtime.Composable()
    public static final void InlineColorPicker(@org.jetbrains.annotations.NotNull()
    com.notesapp.domain.entities.NoteColor selectedColor, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.notesapp.domain.entities.NoteColor, kotlin.Unit> onColorSelected, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}