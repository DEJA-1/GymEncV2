package com.example.gymencv2.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymencv2.R
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.screen.home.components.Header
import com.example.gymencv2.presentation.screen.home.components.MuscleButton

@Composable
fun HomeScreen(navController: NavController) {

    Surface(modifier = Modifier.fillMaxSize(),
    color = AppColors.mBackground) {

        Column {
            Header()

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)){

                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.body, muscleGroup = "Chest", navController)
                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.male, muscleGroup = "Back", navController)
                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.shoulder, muscleGroup = "Shoulders", navController)

            }

            Row(modifier = Modifier.fillMaxWidth()){

                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.muscle, muscleGroup = "Biceps", navController)
                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.triceps, muscleGroup = "Triceps", navController)
                MuscleButton(modifier = Modifier.weight(1f), icon = R.drawable.leg, muscleGroup = "Legs", navController)

            }

        }

    }

}