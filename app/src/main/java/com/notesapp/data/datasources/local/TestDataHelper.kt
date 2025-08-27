package com.notesapp.data.datasources.local

import com.notesapp.domain.entities.ChecklistItem
import com.notesapp.domain.entities.Note
import com.notesapp.domain.entities.NoteColor
import com.notesapp.domain.entities.NoteContent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Helper class to create test data for the app
 */
@Singleton
class TestDataHelper @Inject constructor(
    private val localDataSource: NotesLocalDataSource
) {
    
    suspend fun createTestNotes() {
        val testNotes = listOf(
            Note.createTextNote(
                title = "Добро пожаловать в приложение заметок!",
                content = "Это ваша первая заметка. Вы можете:\n\n• Создавать новые заметки\n• Редактировать существующие\n• Менять цвета заметок\n• Создавать чек-листы\n• Синхронизировать с Google Drive\n\nПриложение поддерживает совместную работу в реальном времени!",
                userId = "test_user",
                color = NoteColor.YELLOW
            ),
            Note.createChecklistNote(
                title = "Список покупок",
                items = listOf(
                    ChecklistItem.create("Молоко", 0),
                    ChecklistItem.create("Хлеб", 1),
                    ChecklistItem("completed_item", "Яйца", true, 2),
                    ChecklistItem.create("Масло", 3),
                    ChecklistItem("completed_item2", "Мука", true, 4)
                ),
                userId = "test_user",
                color = NoteColor.GREEN
            ),
            Note.createTextNote(
                title = "Идеи для улучшения приложения",
                content = "• Добавить темную тему\n• Улучшить поиск по заметкам\n• Добавить систему тегов\n• Экспорт в PDF\n• Голосовые заметки\n• Напоминания",
                userId = "test_user",
                color = NoteColor.BLUE
            ),
            Note.createChecklistNote(
                title = "План на неделю",
                items = listOf(
                    ChecklistItem("monday", "Понедельник: Встреча с командой", true, 0),
                    ChecklistItem.create("Вторник: Работа над проектом", 1),
                    ChecklistItem.create("Среда: Презентация результатов", 2),
                    ChecklistItem.create("Четверг: Планирование следующей итерации", 3),
                    ChecklistItem.create("Пятница: Демо для клиента", 4)
                ),
                userId = "test_user",
                color = NoteColor.PURPLE
            ),
            Note.createTextNote(
                title = "Рецепт борща",
                content = "Ингредиенты:\n- Свекла - 2 шт\n- Капуста - 300г\n- Морковь - 1 шт\n- Лук - 1 шт\n- Картофель - 3 шт\n- Мясо - 500г\n\nПриготовление:\n1. Сварить мясной бульон\n2. Добавить нарезанные овощи\n3. Варить 40 минут\n4. Добавить специи по вкусу",
                userId = "test_user",
                color = NoteColor.ORANGE
            )
        )
        
        // Convert to entities and save
        testNotes.forEach { note ->
            val entity = com.notesapp.data.mappers.NoteMapper.toEntity(note)
            localDataSource.saveNote(entity)
        }
    }
}