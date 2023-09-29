package com.example.recipe_app.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yemek(
    @SerializedName("id")
    var id:Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description:String?=""
    ) : Serializable
