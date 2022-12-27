package com.example.gymencv2.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymencv2.data.repository.ExerciseRepositoryImpl
import com.example.gymencv2.domain.model.Exercise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel : ViewModel() {

    private val repository = ExerciseRepositoryImpl()

    var exerciseListResponse : List<Exercise> by mutableStateOf(arrayListOf())
    var errorMessage: String by mutableStateOf("")

    fun getExercises(): List<Exercise>{
        viewModelScope.launch {
            try {
                val exerciseList = repository.getExercises()
                exerciseListResponse = exerciseList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.e("msg", errorMessage)
            }

        }
        return exerciseListResponse
    }

}