package com.example.recipe_app.retrofit

import com.example.recipe_app.data.entity.YemekCevap
import dagger.Provides
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface YemeklerDao {
    //https://api.canerture.com/recipes/get_recipes.php

    @GET("recipes/get_recipes.php")
    fun tumYemek():Call<YemekCevap>

    @POST("recipes/search_recipe.php")
    @FormUrlEncoded
    fun yemekAra(@Field("name") name: String): Call<YemekCevap>
}