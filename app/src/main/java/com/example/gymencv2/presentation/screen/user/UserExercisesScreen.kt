package com.example.gymencv2.presentation.screen.user

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.navigation.Screen
import com.example.gymencv2.presentation.common_components.GoToButton
import com.example.gymencv2.presentation.common_components.MyTopBar
import com.example.gymencv2.presentation.screen.sample.components.ExerciseRow
import com.example.gymencv2.presentation.screen.user.components.UserExerciseRow
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun UserExercisesScreen(navController: NavController, muscleGroup: String, viewModel: ExerciseViewModel, exerciseListFromDb: List<Exercise>) {

    val mExerciseList = exerciseListFromDb.filter { it.muscle == muscleGroup }
    Log.d("TEST2", " $exerciseListFromDb, $mExerciseList, $muscleGroup")

    var isExerciseListEmpty by remember {
        mutableStateOf(false)
    }

    isExerciseListEmpty = mExerciseList.isEmpty()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {
        Column() {

            MyTopBar(navController = navController)

            if (isExerciseListEmpty) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center) {
                    Text(text = "Exercise list is empty.",
                    fontWeight = FontWeight.Bold,
                    color = AppColors.mMain)
                }
            } else {
                LazyColumn(Modifier.weight(1f)) {

                    items(mExerciseList) {
                        UserExerciseRow(exercise = it, viewModel = viewModel)
                    }

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