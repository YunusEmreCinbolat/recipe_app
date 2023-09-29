package com.example.recipe_app.retrofit

class ApiUtils {
    companion object{
        val BASE_URL="https://api.canerture.com/"
        fun getYemeklerDao(): YemeklerDao{
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)
        }
    }
}