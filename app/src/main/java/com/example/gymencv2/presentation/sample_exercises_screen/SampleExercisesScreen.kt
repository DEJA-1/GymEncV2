package com.example.gymencv2.presentation.sample_exercises_screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.presentation.home_screen.components.MyTopBar
import com.example.gymencv2.presentation.sample_exercises_screen.Components.ExerciseRow
import com.example.gymencv2.presentation.sample_exercises_screen.Components.UserExercisesButton
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun SampleExerciseScreen(navController: NavController, muscleGroup: String, viewModel: ExerciseViewModel, exerciseList: List<Exercise>) {

    val mExerciseList = exerciseList.filter { it.muscle == muscleGroup }

    Surface(modifier = Modifier.fillMaxSize(),
    color = AppColors.mBackground) {

        Column {

            MyTopBar(navController = navController)

            LazyColumn(Modifier.weight(1f)){
                
                items(mExerciseList) {
                    ExerciseRow(exercise = it)
                }
                
            }
            
            UserExercisesButton()
        }

    }

}