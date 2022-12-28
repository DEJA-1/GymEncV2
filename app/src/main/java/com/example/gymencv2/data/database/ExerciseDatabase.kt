package com.example.gymencv2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gymencv2.domain.model.Exercise

@Database(entities = [Exercise::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase : RoomDatabase() {

    abstract val exerciseDao: ExerciseDao

    companion object {
        const val DATABASE_NAME = "exercise_db"
    }

}