package com.jamesnyakush.notes.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.ui.nav.Screen
import com.jamesnyakush.notes.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun NoteListScreen(
    navController: NavController
) {
    val viewModel = getViewModel<NoteViewModel>()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            LazyColumn() {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.getNotes().collect { notes ->
                        items(items = notes) {
                            MyNotes(note = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyNotes(note: Note) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(modifier = Modifier.padding(8.dp), text = note.title)

            Text(modifier = Modifier.padding(8.dp), text = note.description)
        }
    }
}


@Preview
@Composable
fun NoteListScreenPreview() {
    NoteListScreen(rememberNavController())
}