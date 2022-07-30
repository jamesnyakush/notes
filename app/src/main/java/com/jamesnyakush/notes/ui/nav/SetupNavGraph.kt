package com.jamesnyakush.notes.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jamesnyakush.notes.ui.screen.AddNoteScreen
import com.jamesnyakush.notes.ui.screen.NoteListScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.NoteList.route
    ) {

        composable(
            route = Screen.NoteList.route
        ) {
            NoteListScreen(navHostController)
        }

        composable(
            route = Screen.AddNote.route
        ) {
            AddNoteScreen(navHostController)
        }
    }
}