package com.example.gymencv2.domain.repository

import com.example.gymencv2.domain.model.Exercises

interface ExerciseRepository {

    suspend fun getExercises() : Exercises

}