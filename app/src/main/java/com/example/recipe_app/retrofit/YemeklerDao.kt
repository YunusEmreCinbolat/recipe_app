package com.example.recipe_app.retrofit

import com.example.recipe_app.data.entity.CRUDsonuc
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.data.entity.YemekCevap
import com.example.recipe_app.data.entity.YemekDetayCevap
import dagger.Provides
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface YemeklerDao {
    //https://api.canerture.com/recipes/get_recipes.php

    @GET("recipes/get_recipes.php")
    fun tumYemek():Call<YemekCevap>

    @GET("recipes/search_recipe.php")
    fun yemekAra(@Query("query") query: String): Call<YemekCevap>

    @POST("recipes/add_recipe.php")
    fun yemekEkle(@Body request:Yemek): Call<CRUDsonuc>

    @GET("recipes/get_recipe_detail.php")
    fun yemekDetay(@Query("id") id: Int):Call<YemekDetayCevap>

    @POST("recipes/update_recipe.php")
    fun yemekGuncelle(@Body request:Yemek): Call<CRUDsonuc>

}