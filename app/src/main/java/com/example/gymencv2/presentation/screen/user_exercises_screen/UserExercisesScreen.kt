package com.example.gymencv2.presentation.screen.user_exercises_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.navigation.Screen
import com.example.gymencv2.presentation.common_components.GoToButton
import com.example.gymencv2.presentation.common_components.MyTopBar
import com.example.gymencv2.presentation.screen.sample_exercises_screen.components.ExerciseRow
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun UserExercisesScreen(navController: NavController, muscleGroup: String, viewModel: ExerciseViewModel, exerciseListFromDb: List<Exercise>) {

    val mExerciseList = exerciseListFromDb.filter { it.muscle == muscleGroup }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        Column() {

            MyTopBar(navController = navController)

            LazyColumn(Modifier.weight(1f)) {

                items(mExerciseList) {
                    ExerciseRow(exercise = it)
                }

            }

            GoToButton(
                navController = navController,
                text = "ADD EXERCISE",
                route = Screen.Add.passMuscleGroup(muscleGroup)
            )

        }
    }
}