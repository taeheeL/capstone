package com.haeti.capstone.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.haeti.capstone.navigation.MainNavHost
import com.haeti.capstone.ui.theme.CapstoneTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneTheme {
                val navController = rememberNavController()
                MainNavHost(navController = navController, viewModel = mainViewModel)
            }
        }
    }
}