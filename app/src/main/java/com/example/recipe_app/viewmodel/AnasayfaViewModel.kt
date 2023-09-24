package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository

class AnasayfaViewModel:ViewModel() {
    val yemekrepo= YemeklerDaRepository()

    fun yemekAra(arananYemek:String){
        yemekrepo.yemekAra(arananYemek)
    }
}