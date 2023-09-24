package com.example.recipe_app.di

import com.example.recipe_app.data.repo.YemeklerDaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaRepository():YemeklerDaRepository{
        return YemeklerDaRepository()
    }
}