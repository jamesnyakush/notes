package com.jamesnyakush.notes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jamesnyakush.notes.ui.nav.SetupNavGraph
import com.jamesnyakush.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                navController = rememberNavController()
                SetupNavGraph(navHostController = navController)
            }
        }
    }
}