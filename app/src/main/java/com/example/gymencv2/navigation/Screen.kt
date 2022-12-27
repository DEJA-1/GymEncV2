package com.example.gymencv2.navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SampleExercise: Screen(route = "sample_exercise_screen")

}
