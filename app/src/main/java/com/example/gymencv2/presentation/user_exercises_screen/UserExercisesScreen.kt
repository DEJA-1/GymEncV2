package com.example.gymencv2.presentation.user_exercises_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.home_screen.components.MyTopBar

@Composable
fun UserExercisesScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        MyTopBar(navController = navController)
    }


}