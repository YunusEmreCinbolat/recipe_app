package com.example.recipe_app.di

import com.example.recipe_app.data.repo.YemeklerDaRepository
import com.example.recipe_app.retrofit.ApiUtils
import com.example.recipe_app.retrofit.YemeklerDao

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
class AppModule {
  
    @Provides
    @Singleton

    fun provideYemeklerDaRepository(yemeklerDao: YemeklerDao):YemeklerDaRepository{
        return YemeklerDaRepository(yemeklerDao)
    }
    @Provides
    @Singleton
    fun provideYemeklerDao():YemeklerDao{
        return ApiUtils.getYemeklerDao()
    }

}