package com.notesapp.domain.entities

/**
 * Перечисление цветов для заметок
 */
enum class NoteColor(val displayName: String, val colorValue: String) {
    DEFAULT("По умолчанию", "#FFFFFF"),
    YELLOW("Желтый", "#FEF7C0"),
    GREEN("Зеленый", "#E8F5E8"),
    BLUE("Синий", "#E1F4FD"),
    RED("Красный", "#FDE1E1"),
    PURPLE("Фиолетовый", "#F3E8FF"),
    ORANGE("Оранжевый", "#FEF2E0")
}