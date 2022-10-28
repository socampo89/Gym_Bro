package com.godbless.gymbro.android.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.godbless.gymbro.android.home.composables.Welcome
import com.godbless.gymbro.android.home.composables.Workouts

@Composable
fun HomeScreen(welcomeText : String, navController: NavController, modifier: Modifier = Modifier, viewModel : HomeScreenViewModel)  {
    val state = viewModel.state.collectAsState()
    Scaffold {
        Column(
            modifier = modifier.padding(it).fillMaxSize()
        ) {
            Welcome(welcomeText = welcomeText, user = state.value.user)
            Workouts()
        }
    }

}
