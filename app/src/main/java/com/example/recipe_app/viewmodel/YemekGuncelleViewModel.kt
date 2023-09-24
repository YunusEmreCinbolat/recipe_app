package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekGuncelleViewModel @Inject constructor(val yemekrepo:YemeklerDaRepository): ViewModel() {
    fun yemekGuncelle(yemekId:Int, yemekAd:String,yemekTanim:String){
        yemekrepo.yemekGuncelle(yemekId,yemekAd,yemekTanim)
    }
}