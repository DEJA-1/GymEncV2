package com.example.gymencv2.presentation.home_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.gymencv2.domain.model.Exercise

@Composable
fun ExerciseList(exerciseList: List<Exercise>) {

    LazyColumn {

        itemsIndexed(items = exerciseList) {index, item ->
            ExerciseItem(exercise = item)
        }

    }

}