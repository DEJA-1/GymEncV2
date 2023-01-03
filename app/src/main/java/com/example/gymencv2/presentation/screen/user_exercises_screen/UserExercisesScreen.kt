package com.example.gymencv2.presentation.screen.user_exercises_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.navigation.Screen
import com.example.gymencv2.presentation.common_components.GoToButton
import com.example.gymencv2.presentation.common_components.MyTopBar

@Composable
fun UserExercisesScreen(navController: NavController, muscleGroup: String) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        Column() {

            Box(modifier = Modifier.fillMaxSize().weight(1f)) {
                MyTopBar(navController = navController)
            }

            GoToButton(navController = navController, text = "ADD EXERCISE", route = Screen.Add.passMuscleGroup(muscleGroup))

        }
    }
}