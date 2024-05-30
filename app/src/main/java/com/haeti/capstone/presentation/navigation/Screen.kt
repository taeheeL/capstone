package com.haeti.capstone.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Main : Screen("main")
    data object Result : Screen("result") {
        fun createRoute(result: Int) = "result/$result"
    }
}