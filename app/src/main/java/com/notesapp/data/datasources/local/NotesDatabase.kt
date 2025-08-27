package com.notesapp.data.datasources.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.notesapp.data.entities.NoteEntity

/**
 * Room база данных для приложения заметок
 */
@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {
    
    abstract fun notesDao(): NotesDao
    
    companion object {
        const val DATABASE_NAME = "notes_database"
    }
}

/**
 * Миграции базы данных
 */
object DatabaseMigrations {
    
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Пример будущей миграции
            // database.execSQL("ALTER TABLE notes ADD COLUMN driveFileId TEXT")
        }
    }
}