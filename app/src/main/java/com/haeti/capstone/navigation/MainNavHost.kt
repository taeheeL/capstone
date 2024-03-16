package com.haeti.capstone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.haeti.capstone.home.HomeScreen
import com.haeti.capstone.main.MainScreen
import com.haeti.capstone.main.MainViewModel
import com.haeti.capstone.result.ResultScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, mainViewModel = viewModel)
        }
        composable(Screen.Main.route) {
            MainScreen(navController = navController, mainViewModel = viewModel)
        }
        composable(Screen.Result.route) {
            ResultScreen(navController = navController, mainViewModel = viewModel)
        }
    }
}