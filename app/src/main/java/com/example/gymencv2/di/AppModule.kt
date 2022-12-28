package com.example.gymencv2.di

import android.app.Application
import androidx.room.Room
import com.example.gymencv2.common.Constants
import com.example.gymencv2.data.database.ExerciseDatabase
import com.example.gymencv2.data.remote.ExerciseApi
import com.example.gymencv2.data.repository.ExerciseRepositoryImpl
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.domain.repository.ExerciseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideExerciseApi(): ExerciseApi {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()


        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExerciseApi::class.java)

    }

    @Provides
    @Singleton
    fun provideExerciseDatabase(app: Application): ExerciseDatabase {

        return Room.databaseBuilder(
            app,
            ExerciseDatabase::class.java,
            ExerciseDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideExerciseRepository(api: ExerciseApi, db: ExerciseDatabase) : ExerciseRepository {
        return ExerciseRepositoryImpl(api, db.exerciseDao)
    }

}