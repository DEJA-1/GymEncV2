package com.example.gymencv2.data.repository

import android.util.Log
import com.example.gymencv2.common.DataOrException
import com.example.gymencv2.data.database.ExerciseDao
import com.example.gymencv2.data.remote.ExerciseApi
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val api: ExerciseApi,
    private val dao: ExerciseDao
) : ExerciseRepository {

    private val dataOrException = DataOrException<List<Exercise>, Boolean, Exception>()

    override suspend fun getExercises(): DataOrException<List<Exercise>, Boolean, java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getExercises()

            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false

        } catch (exception: Exception) {

            dataOrException.e = exception
            Log.d("Exc", "getExercises: ${dataOrException.e!!.localizedMessage}")

        }

        return dataOrException
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