package com.notesapp.data.datasources.remote;

/**
 * Implementation of Google Drive service
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0011J\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@\u00a2\u0006\u0002\u0010 J\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\"0\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0011J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010%\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010\'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006("}, d2 = {"Lcom/notesapp/data/datasources/remote/GoogleDriveServiceImpl;", "Lcom/notesapp/data/datasources/remote/GoogleDriveService;", "authManager", "Lcom/notesapp/data/datasources/remote/GoogleAuthManager;", "(Lcom/notesapp/data/datasources/remote/GoogleAuthManager;)V", "driveService", "Lcom/google/api/services/drive/Drive;", "gson", "Lcom/google/gson/Gson;", "notesFolder", "", "targetFolderId", "testMode", "", "createNotesFolder", "Lkotlin/Result;", "createNotesFolder-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "", "fileId", "deleteNote-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadNote", "Lcom/notesapp/domain/entities/Note;", "downloadNote-gIAlu-s", "getMetadata", "Lcom/notesapp/domain/entities/NotesMetadata;", "getMetadata-IoAF18A", "initializeDriveService", "credential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "(Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncNotes", "", "syncNotes-IoAF18A", "uploadNote", "note", "uploadNote-gIAlu-s", "(Lcom/notesapp/domain/entities/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GoogleDriveServiceImpl implements com.notesapp.data.datasources.remote.GoogleDriveService {
    @org.jetbrains.annotations.NotNull()
    private final com.notesapp.data.datasources.remote.GoogleAuthManager authManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.api.services.drive.Drive driveService;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String notesFolder = "Notes App";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String targetFolderId = "1KzLFmGOmBIuisUA4F4oqcoAo22AVQRsU";
    private final boolean testMode = true;
    
    @javax.inject.Inject()
    public GoogleDriveServiceImpl(@org.jetbrains.annotations.NotNull()
    com.notesapp.data.datasources.remote.GoogleAuthManager authManager) {
        super();
    }
    
    /**
     * Initialize Google Drive service with credentials
     */
    private final java.lang.Object initializeDriveService(com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential credential, kotlin.coroutines.Continuation<? super com.google.api.services.drive.Drive> $completion) {
        return null;
    }
}