package com.jamesnyakush.notes.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddNoteScreen(
    navController: NavController
) {
//    Column() {
//        OutlinedTextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            value = text,
//            onValueChange = {
//                text = it
//            },
//            label = { Text(text = "Enter Your Password") }
//        )
//
//        Button(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            shape = CutCornerShape(4.dp),
//            onClick = {
//                navController.navigate(Screen.Dashboard.route)
//            }
//        ) {
//            Text(text = "Login")
//        }
//    }
}

@Preview
@Composable
fun AddNoteScreenPreview() {
    AddNoteScreen(rememberNavController())
}