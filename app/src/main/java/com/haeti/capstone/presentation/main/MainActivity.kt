package com.haeti.capstone.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.haeti.capstone.presentation.navigation.MainNavHost
import com.haeti.capstone.presentation.theme.CapstoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneTheme {
                val navController = rememberNavController()
                MainNavHost(navController = navController)
            }
        }
    }
}