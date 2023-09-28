package com.example.recipe_app.data.entity

import com.google.gson.annotations.SerializedName

data class YemekDetayCevap(
    @SerializedName("recipe")
    var recipe:Yemek,
    @SerializedName("status")
    var status:Int,
    @SerializedName("message")
    var message:String
){}

