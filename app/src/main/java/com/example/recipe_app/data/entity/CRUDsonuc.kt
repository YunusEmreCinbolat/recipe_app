package com.example.recipe_app.data.entity

import com.google.gson.annotations.SerializedName

data class CRUDsonuc(
    @SerializedName("status")
    var status:Int,
    @SerializedName("message")
    var message:String
){}
