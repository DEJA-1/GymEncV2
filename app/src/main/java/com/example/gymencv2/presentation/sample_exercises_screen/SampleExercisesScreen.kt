package com.example.gymencv2.presentation.sample_exercises_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.home_screen.components.MyTopBar
import com.example.gymencv2.presentation.sample_exercises_screen.Components.UserExercisesButton

@Preview
@Composable
fun SampleExerciseScreen() {

    Surface(modifier = Modifier.fillMaxSize(),
    color = AppColors.mBackground) {


        Column {

            MyTopBar()

            Text(text = "SampleExercisesScreen",
            style = MaterialTheme.typography.h3,
            color = AppColors.mDetails,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

            UserExercisesButton()
        }

    }

}