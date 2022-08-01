package com.jamesnyakush.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel constructor(
    private val repository: NoteRepository
) : ViewModel() {


    fun upsertNote(note: Note) = viewModelScope.launch {
        repository.upsertNote(note = note)
    }

    //var fetchNoteOffline = repository.getNotes().

    fun getNotes(): Flow<List<Note>> {
        return repository.getNotes()
    }
}