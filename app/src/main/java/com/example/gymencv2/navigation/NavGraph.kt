package com.example.gymencv2.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.presentation.screen.add_screen.AddScreen
import com.example.gymencv2.presentation.screen.home_screen.HomeScreen
import com.example.gymencv2.presentation.screen.sample_exercises_screen.SampleExerciseScreen
import com.example.gymencv2.presentation.screen.user_exercises_screen.UserExercisesScreen
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: ExerciseViewModel) {

    val exerciseList = viewModel.data.value.data?.toList()


    val exerciseListFromDb = viewModel.exerciseListFromDb.collectAsState().value

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.SampleExercise.route,
            arguments = listOf(navArgument(MUSCLE_GROUP_KEY) {
                type = NavType.StringType
            })
        ) {
            SampleExerciseScreen(
                navController = navController,
                muscleGroup = it.arguments?.getString(MUSCLE_GROUP_KEY).toString(),
                exerciseList = exerciseList
            )
        }

        composable(
            route = Screen.UserExercises.route,
            arguments = listOf(navArgument(MUSCLE_GROUP_KEY) {
                type = NavType.StringType
            })
        ) {
            UserExercisesScreen(
                navController = navController,
                muscleGroup = it.arguments?.getString(MUSCLE_GROUP_KEY).toString(),
                viewModel = viewModel,
                exerciseListFromDb = exerciseListFromDb
            )
        }

        composable(
            route = Screen.Add.route,
            arguments = listOf(navArgument(MUSCLE_GROUP_KEY) {
                type = NavType.StringType
            })
        ) {
            AddScreen(
                navController = navController, muscleGroup = it.arguments?.getString(MUSCLE_GROUP_KEY).toString(),
                viewModel = viewModel
            )
        }

    }
}