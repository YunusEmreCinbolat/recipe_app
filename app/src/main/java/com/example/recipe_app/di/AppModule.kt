package com.example.recipe_app.di

import com.example.recipe_app.data.repo.YemeklerDaRepository
import com.example.recipe_app.retrofit.YemeklerDao
import com.example.recipe_app.util.ConstantApi.BASE_URL
import com.example.recipe_app.util.CustomHttpLogger
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
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) }
    @Provides
    @Singleton
    fun provideYemeklerDaRepository(yemekrepo:YemeklerDao):YemeklerDaRepository{
        return YemeklerDaRepository(yemekrepo)
    }

    @Singleton
    @Provides
    fun provideTvShowsApi(okHttpClient: OkHttpClient): YemeklerDao = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
        .create(YemeklerDao::class.java)
    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor(CustomHttpLogger())
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

}