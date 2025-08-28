package com.notesapp.di;

/**
 * Hilt module for binding repository implementations
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/notesapp/di/RepositoryModule;", "", "()V", "bindAuthRepository", "Lcom/notesapp/domain/repositories/AuthRepository;", "authRepositoryImpl", "Lcom/notesapp/data/repositories/AuthRepositoryImpl;", "bindCollaborationRepository", "Lcom/notesapp/domain/repositories/CollaborationRepository;", "collaborationRepositoryImpl", "Lcom/notesapp/data/repositories/CollaborationRepositoryImpl;", "bindGoogleDriveService", "Lcom/notesapp/data/datasources/remote/GoogleDriveService;", "googleDriveServiceImpl", "Lcom/notesapp/data/datasources/remote/GoogleDriveServiceImpl;", "bindNotesRepository", "Lcom/notesapp/domain/repositories/NotesRepository;", "notesRepositoryImpl", "Lcom/notesapp/data/repositories/NotesRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.notesapp.domain.repositories.NotesRepository bindNotesRepository(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.repositories.NotesRepositoryImpl notesRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.notesapp.domain.repositories.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.repositories.AuthRepositoryImpl authRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.notesapp.domain.repositories.CollaborationRepository bindCollaborationRepository(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.repositories.CollaborationRepositoryImpl collaborationRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.notesapp.data.datasources.remote.GoogleDriveService bindGoogleDriveService(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.datasources.remote.GoogleDriveServiceImpl googleDriveServiceImpl);
}