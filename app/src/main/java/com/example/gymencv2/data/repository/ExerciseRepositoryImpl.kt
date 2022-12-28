package com.example.gymencv2.data.repository

import com.example.gymencv2.data.database.ExerciseDao
import com.example.gymencv2.data.remote.ExerciseApi
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val api: ExerciseApi,
    private val dao: ExerciseDao) : ExerciseRepository {

    override suspend fun getExercises(): List<Exercise> {
        return api.getExercises()
    }

    override fun getAllExercisesFromDb(): Flow<List<Exercise>> {
        return dao.getAllExercisesFromDb()
    }

    override suspend fun getExerciseByIdFromDb(id: Int): Exercise? {
        return dao.getExerciseByIdFromDb(id = id)
    }

    override suspend fun insertExerciseToDb(exercise: Exercise) {
        dao.insertExerciseToDb(exercise)
    }

    override suspend fun deleteExerciseFromDb(exercise: Exercise) {
        dao.deleteExerciseFromDb(exercise)
    }
}