package com.example.recipe_app.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(id:Int,it:View){
    findNavController(it).navigate(id)
}
fun Navigation.gecisYap(id:NavDirections,it: View){
    findNavController(it).navigate(id)
}