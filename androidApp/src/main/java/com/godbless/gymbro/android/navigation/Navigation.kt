package com.godbless.gymbro.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.godbless.gymbro.android.R
import com.godbless.gymbro.android.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = navController.context
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(
            route = Screen.HomeScreen.route,
            arguments = listOf(
                navArgument("welcomeTitle"){
                    type = NavType.StringType
                    defaultValue = context.getString(R.string.welcome_title)
                    nullable = true
                }
            )
        ){ entry ->
            val welcomeText = entry.arguments?.getString("welcomeTitle") ?: ""
            HomeScreen(
                welcomeText = welcomeText,
                navController = navController,
                modifier = Modifier,
                viewModel = hiltViewModel())
        }
    }
}