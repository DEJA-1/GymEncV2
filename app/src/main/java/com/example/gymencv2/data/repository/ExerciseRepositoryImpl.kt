package com.example.gymencv2.data.repository

import com.example.gymencv2.data.remote.ExerciseApi
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.domain.repository.ExerciseRepository

class ExerciseRepositoryImpl : ExerciseRepository {

    private val api = ExerciseApi.getInstance()

    override suspend fun getExercises(): List<Exercise> {
        return api.getExercises()

    }

}