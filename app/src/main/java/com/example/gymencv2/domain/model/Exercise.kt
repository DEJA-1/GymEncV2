package com.example.gymencv2.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class Exercise(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "exercise_name")
    val name: String,

    @ColumnInfo(name = "exercise_muscle")
    val muscle: String,

    @ColumnInfo(name = "exercise_description")
    val description: String,

    @ColumnInfo(name = "exercise_image")
    val image: String


)