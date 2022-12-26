package com.example.gymencv2.data.remote

import com.example.gymencv2.common.Constants
import com.example.gymencv2.domain.model.Exercise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ExerciseApi {

    @GET("GymEnc_v2.JSON")
    suspend fun getExercises() : List<Exercise>

    companion object {
        private var exerciseApi: ExerciseApi? = null

        fun getInstance() : ExerciseApi {
            if (exerciseApi == null) {
                exerciseApi = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ExerciseApi::class.java)
            }
            return exerciseApi!!
        }
    }


}