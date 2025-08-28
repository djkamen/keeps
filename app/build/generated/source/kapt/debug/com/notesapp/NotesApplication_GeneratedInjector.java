package com.notesapp;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = NotesApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface NotesApplication_GeneratedInjector {
  void injectNotesApplication(NotesApplication notesApplication);
}
