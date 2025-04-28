package com.jamesnyakush.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {


    fun upsertNote(note: Note) = viewModelScope.launch {
        repository.upsertNote(note = note)
    }

    val notes = repository.getNotes().flowOn(Dispatchers.IO)
}