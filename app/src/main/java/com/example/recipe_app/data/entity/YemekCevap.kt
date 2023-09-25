package com.example.recipe_app.data.entity

import com.google.gson.annotations.SerializedName

data class YemekCevap(@SerializedName("yemekler") var yemekler:List<Yemek>,@SerializedName("success") var success:Int){}
