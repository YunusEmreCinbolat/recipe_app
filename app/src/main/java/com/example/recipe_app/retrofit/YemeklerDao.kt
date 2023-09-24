package com.example.recipe_app.retrofit

import com.example.recipe_app.data.entity.YemekCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDao {
    //https://api.canerture.com/recipes/get_recipes.php

    @GET("recipes/get_recipes.php")
    fun tumYemek():Call<YemekCevap>
}