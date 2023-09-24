package com.example.recipe_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository

class AnasayfaViewModel:ViewModel() {
    val yemekrepo= YemeklerDaRepository()

    fun yemekAra(arananYemek:String){
        yemekrepo.yemekAra(arananYemek)
    }
    fun yemekSil(yemekId: Int,yemekAd: String,yemekTanim: String){
        yemekrepo.yemekSil(yemekId, yemekAd = yemekAd,yemekTanim)
    }
}