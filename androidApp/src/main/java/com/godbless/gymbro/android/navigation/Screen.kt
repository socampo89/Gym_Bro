package com.godbless.gymbro.android.navigation

sealed class Screen(val route : String) {
    object HomeScreen : Screen("home_screen")
}