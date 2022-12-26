package com.example.gymencv2.domain.repository

import com.example.gymencv2.domain.model.Exercise

interface ExerciseRepository {

    suspend fun getExercises() : List<Exercise>

}