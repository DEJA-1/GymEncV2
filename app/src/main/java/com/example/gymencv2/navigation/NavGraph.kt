package com.example.gymencv2.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.presentation.home_screen.HomeScreen
import com.example.gymencv2.presentation.sample_exercises_screen.SampleExerciseScreen
import com.example.gymencv2.presentation.user_exercises_screen.UserExercisesScreen
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: ExerciseViewModel) {

    val exerciseList = viewModel.getExercises()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.SampleExercise.route,
            arguments = listOf(navArgument(SAMPLE_EXERCISE_SCREEN_KEY) {
                type = NavType.StringType
            })
        ) {
            SampleExerciseScreen(navController = navController, viewModel = viewModel, muscleGroup = it.arguments?.getString(
                SAMPLE_EXERCISE_SCREEN_KEY).toString(), exerciseList = exerciseList)
        }

        composable(
            route = Screen.UserExercises.route
        ) {
            UserExercisesScreen(navController = navController)
        }

    }
}