package com.notesapp.data.datasources.remote

import com.google.firebase.database.*
import com.notesapp.domain.entities.ActiveUser
import com.notesapp.domain.entities.NoteChange
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Firebase Realtime Database service for collaboration
 */
@Singleton
class FirebaseRealtimeService @Inject constructor() {
    
    private val database = FirebaseDatabase.getInstance().reference
    
    fun observeNoteChanges(noteId: String): Flow<NoteChange> = callbackFlow {
        val listener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // Parse and emit note changes
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        
        database.child("note_changes").child(noteId).addChildEventListener(listener)
        awaitClose { database.child("note_changes").child(noteId).removeEventListener(listener) }
    }
    
    suspend fun publishChange(change: NoteChange): Result<Unit> {
        return try {
            database.child("note_changes").child(change.noteId).push().setValue(change).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun setUserActive(noteId: String, user: ActiveUser): Result<Unit> {
        return try {
            database.child("active_users").child(noteId).child(user.userId).setValue(user).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}