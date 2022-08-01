package com.jamesnyakush.notes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jamesnyakush.notes.data.db.dao.NoteDao
import com.jamesnyakush.notes.data.db.entity.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1,
    exportSchema = false
)

abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}