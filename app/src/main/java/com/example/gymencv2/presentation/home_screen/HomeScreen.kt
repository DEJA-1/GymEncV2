package com.example.gymencv2.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymencv2.R
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.presentation.home_screen.components.ExerciseList
import com.example.gymencv2.presentation.home_screen.components.Header
import com.example.gymencv2.presentation.home_screen.components.MuscleButton
import com.example.gymencv2.presentation.home_screen.components.MyTopBar
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

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