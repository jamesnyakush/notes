package com.jamesnyakush.notes.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NoteListScreen(
    navController: NavController
) {

}


@Preview
@Composable
fun NoteListScreenPreview() {
    NoteListScreen(rememberNavController())
}