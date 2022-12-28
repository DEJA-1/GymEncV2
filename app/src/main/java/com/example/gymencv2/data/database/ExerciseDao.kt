package com.example.gymencv2.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gymencv2.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise_table")
    fun getAllExercisesFromDb(): Flow<List<Exercise>>

    @Query("SELECT * FROM exercise_table WHERE id = :id")
    fun getExerciseByIdFromDb(id: Int) : Exercise?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExerciseToDb(exercise: Exercise)

    @Delete
    suspend fun deleteExerciseFromDb(exercise: Exercise)

}