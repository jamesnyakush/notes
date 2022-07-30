package com.jamesnyakush.notes.ui.nav

sealed class Screen(val route: String) {
    object NoteList : Screen(route = "note_list")
    object AddNote : Screen(route = "add_note")
}