package com.example.recipe_app.data.entity

import com.google.gson.annotations.SerializedName

data class YemekCevap(@SerializedName("recipes") var recipes:List<Yemek>, @SerializedName("status") var status:Int, @SerializedName("message") var message:String){}
