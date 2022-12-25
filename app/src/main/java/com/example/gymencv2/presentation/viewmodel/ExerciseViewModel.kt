package com.example.gymencv2.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymencv2.data.repository.ExerciseRepositoryImpl
import com.example.gymencv2.domain.model.Exercises
import com.example.gymencv2.domain.model.ExercisesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel : ViewModel() {

    val repository = ExerciseRepositoryImpl()

    var exerciseListResponse : List<ExercisesItem> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")


    fun getExercises() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val exerciseList = repository.getExercises()
                exerciseListResponse = exerciseList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }

}