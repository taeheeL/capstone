package com.haeti.capstone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.haeti.capstone.presentation.home.HomeScreen
import com.haeti.capstone.presentation.main.MainScreen
import com.haeti.capstone.presentation.result.ResultScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("result") { type = NavType.IntType })
        ) { backStackEntry ->
            val result = backStackEntry.arguments?.getInt("result") ?: 0
            ResultScreen(navController = navController, result = result)
        }
    }
}