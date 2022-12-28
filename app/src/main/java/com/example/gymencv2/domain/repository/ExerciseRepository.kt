package com.example.gymencv2.domain.repository

import com.example.gymencv2.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    suspend fun getExercises() : List<Exercise>

    fun getAllExercisesFromDb() : Flow<List<Exercise>>

    suspend fun getExerciseByIdFromDb(id: Int) : Exercise?

    suspend fun insertExerciseToDb(exercise: Exercise)

    suspend fun deleteExerciseFromDb(exercise: Exercise)

}