package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository

class YemekGuncelleViewModel: ViewModel() {
    val yemekrepo= YemeklerDaRepository()
    fun yemekGuncelle(yemekId:Int, yemekAd:String,yemekTanim:String){
        yemekrepo.yemekGuncelle(yemekId,yemekAd,yemekTanim)
    }
}