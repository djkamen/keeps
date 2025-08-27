package com.notesapp.di

import android.content.Context
import androidx.room.Room
import com.notesapp.data.datasources.local.NotesDao
import com.notesapp.data.datasources.local.NotesDatabase
import com.notesapp.data.datasources.local.NotesLocalDataSource
import com.notesapp.data.datasources.local.NotesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt модуль для настройки базы данных
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            NotesDatabase.DATABASE_NAME
        ).build()
    }
    
    @Provides
    fun provideNotesDao(database: NotesDatabase): NotesDao {
        return database.notesDao()
    }
    
    @Provides
    @Singleton
    fun provideNotesLocalDataSource(notesDao: NotesDao): NotesLocalDataSource {
        return NotesLocalDataSourceImpl(notesDao)
    }
}