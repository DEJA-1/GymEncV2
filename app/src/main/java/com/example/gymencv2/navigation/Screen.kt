package com.example.gymencv2.navigation

const val MUSCLE_GROUP_KEY = "muscleGroup"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")

    object SampleExercise: Screen(route = "sample_exercises_screen/{$MUSCLE_GROUP_KEY}") {
        fun passMuscleGroup(muscleGroup: String) : String {
            return "sample_exercises_screen/$muscleGroup"
        }
    }

    object UserExercises: Screen(route = "user_exercises_screen/{$MUSCLE_GROUP_KEY}") {
        fun passMuscleGroup(muscleGroup: String) : String {
            return "user_exercises_screen/$muscleGroup"
        }
    }

    object Add: Screen(route = "add_screen/{$MUSCLE_GROUP_KEY}") {
        fun passMuscleGroup(muscleGroup: String) : String {
            return "add_screen/$muscleGroup"
        }
    }

}
