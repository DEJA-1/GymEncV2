package com.example.gymencv2.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymencv2.common.DataOrException
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

    val data: MutableState<DataOrException<List<Exercise>, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    init {
        getExercises()
    }

    private fun getExercises() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getExercises()

            if (data.value.data.toString().isNotEmpty())
                data.value.loading = false
        }
    }

    fun insertExerciseToDb(exercise: Exercise) = viewModelScope.launch {
        repository.insertExerciseToDb(exercise)
    }
}