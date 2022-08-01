package com.jamesnyakush.notes.data.repository

import com.jamesnyakush.notes.data.db.dao.NoteDao
import com.jamesnyakush.notes.data.db.entity.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl constructor(
    private val dao: NoteDao
) : NoteRepository {

    override suspend fun upsertNote(note: Note) {
        dao.upsertNote(note)
    }

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

}