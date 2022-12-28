package com.example.gymencv2.navigation

const val SAMPLE_EXERCISE_SCREEN_KEY = "muscleGroup"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")

    object SampleExercise: Screen(route = "sample_exercise_screen/{$SAMPLE_EXERCISE_SCREEN_KEY}") {
        fun passMuscleGroup(muscleGroup: String) : String {
            return "sample_exercise_screen/$muscleGroup"
        }
    }

    object UserExercises: Screen(route = "user_exercises_screen")

}
