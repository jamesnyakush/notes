package com.jamesnyakush.notes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.ui.nav.Screen
import com.jamesnyakush.notes.ui.viewmodel.NoteViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NoteListScreen(
    navController: NavController,
    viewModel: NoteViewModel = koinViewModel()
) {
    val notes = viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Note",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Notes",
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn {
                items(
                    notes.value.size,
                ) { note ->
                    MyNotes(note = notes.value[note])
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
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF),
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = note.title,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = note.description,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}