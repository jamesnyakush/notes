package com.jamesnyakush.notes.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jamesnyakush.notes.data.db.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNote(notes: Note)

    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<Note>>
}