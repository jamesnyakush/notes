package com.jamesnyakush.notes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jamesnyakush.notes.data.db.entity.Note
import com.jamesnyakush.notes.ui.nav.Screen
import com.jamesnyakush.notes.ui.viewmodel.NoteViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AddNoteScreen(
    navController: NavController
) {

    val vm = getViewModel<NoteViewModel>()


    Column(
        modifier = Modifier.fillMaxWidth()
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

@Preview
@Composable
fun AddNoteScreenPreview() {
    AddNoteScreen(rememberNavController())
}