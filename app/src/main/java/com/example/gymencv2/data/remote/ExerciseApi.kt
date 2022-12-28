package com.example.gymencv2.data.remote

import com.example.gymencv2.common.Constants
import com.example.gymencv2.domain.model.Exercise
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ExerciseApi {

    @GET("GymEnc_v2.JSON")
    suspend fun getExercises() : List<Exercise>

}