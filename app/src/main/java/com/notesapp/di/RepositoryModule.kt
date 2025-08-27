package com.notesapp.di

import com.notesapp.data.repositories.AuthRepositoryImpl
import com.notesapp.data.repositories.CollaborationRepositoryImpl
import com.notesapp.data.repositories.NotesRepositoryImpl
import com.notesapp.domain.repositories.AuthRepository
import com.notesapp.domain.repositories.CollaborationRepository
import com.notesapp.domain.repositories.NotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for binding repository implementations
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindNotesRepository(
        notesRepositoryImpl: NotesRepositoryImpl
    ): NotesRepository
    
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
    
    @Binds
    @Singleton
    abstract fun bindCollaborationRepository(
        collaborationRepositoryImpl: CollaborationRepositoryImpl
    ): CollaborationRepository
}