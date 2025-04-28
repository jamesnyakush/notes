package com.jamesnyakush.notes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.ui.nav.Screen
import com.jamesnyakush.notes.ui.viewmodel.NoteViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddNoteScreen(
    navController: NavController,
    vm: NoteViewModel = koinViewModel()
) {

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {

                var title by remember { mutableStateOf(TextFieldValue("")) }
                var description by remember { mutableStateOf(TextFieldValue("")) }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    label = {
                        Text(text = "Title")
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    label = {
                        Text(text = "Description")
                    },
                    maxLines = 8
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = CutCornerShape(4.dp),
                    onClick = {
                        vm.upsertNote(
                            Note(
                                title = title.text,
                                description = description.text
                            )
                        )

                        navController.navigate(Screen.NoteList.route)
                    }
                ) {
                    Text(text = "Add Note")
                }
            }
        }
    )
}