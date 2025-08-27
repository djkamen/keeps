package com.notesapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Цветовые схемы для светлой и темной темы
 */
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6750A4),
    secondary = Color(0xFF625B71),
    tertiary = Color(0xFF7D5260),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6750A4),
    secondary = Color(0xFF625B71),
    tertiary = Color(0xFF7D5260),
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

/**
 * Цвета заметок
 */
object NoteColors {
    val Default = Color(0xFFFFFFFF)
    val Yellow = Color(0xFFFEF7C0)
    val Green = Color(0xFFE8F5E8)
    val Blue = Color(0xFFE1F4FD)
    val Red = Color(0xFFFDE1E1)
    val Purple = Color(0xFFF3E8FF)
    val Orange = Color(0xFFFEF2E0)
    
    fun fromNoteColor(noteColor: com.notesapp.domain.entities.NoteColor): Color {
        return when (noteColor) {
            com.notesapp.domain.entities.NoteColor.DEFAULT -> Default
            com.notesapp.domain.entities.NoteColor.YELLOW -> Yellow
            com.notesapp.domain.entities.NoteColor.GREEN -> Green
            com.notesapp.domain.entities.NoteColor.BLUE -> Blue
            com.notesapp.domain.entities.NoteColor.RED -> Red
            com.notesapp.domain.entities.NoteColor.PURPLE -> Purple
            com.notesapp.domain.entities.NoteColor.ORANGE -> Orange
        }
    }
}

/**
 * Основная тема приложения
 */
@Composable
fun NotesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}