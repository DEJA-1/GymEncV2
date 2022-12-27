package com.example.gymencv2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymencv2.presentation.home_screen.HomeScreen
import com.example.gymencv2.presentation.sample_exercises_screen.SampleExerciseScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {


    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.SampleExercise.route
        ) {
            SampleExerciseScreen(navController = navController)
        }

    }
}