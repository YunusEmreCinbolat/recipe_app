package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YemekKayitViewModel @Inject constructor (val yemekrepo:YemeklerDaRepository): ViewModel() {
    fun yemekKayit(yemekAd:String,yemekTanim:String){
        yemekrepo.yemekKayit(yemekAd,yemekTanim)
    }
}