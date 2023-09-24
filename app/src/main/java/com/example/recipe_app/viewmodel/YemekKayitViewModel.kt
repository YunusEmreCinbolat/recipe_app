package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository

class YemekKayitViewModel: ViewModel() {
    val yemekrepo=YemeklerDaRepository()
    fun yemekKayit(yemekAd:String,yemekTanim:String){
        yemekrepo.yemekKayit(yemekAd,yemekTanim)
    }
}