package com.notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Главный класс приложения с Hilt DI
 */
@HiltAndroidApp
class NotesApplication : Application()