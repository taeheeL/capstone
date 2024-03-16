package com.haeti.capstone.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Main : Screen("main")
    data object Result : Screen("result")
}