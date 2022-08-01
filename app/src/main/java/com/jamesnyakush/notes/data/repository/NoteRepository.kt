package com.jamesnyakush.notes.data.repository

import com.jamesnyakush.notes.data.db.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun upsertNote(note: Note)

    fun getNotes(): Flow<List<Note>>
}