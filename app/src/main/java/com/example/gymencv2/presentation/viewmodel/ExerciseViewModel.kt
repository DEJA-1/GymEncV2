package com.example.gymencv2.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymencv2.data.repository.ExerciseRepositoryImpl
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.domain.repository.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repository: ExerciseRepository
) : ViewModel() {

    private val _exerciseListDb = MutableStateFlow<List<Exercise>>(emptyList())
    val exerciseListDb = _exerciseListDb.asStateFlow()

    var exerciseListResponse: List<Exercise> by mutableStateOf(arrayListOf())
    var errorMessage: String by mutableStateOf("")

    fun getExercises(): List<Exercise> {
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