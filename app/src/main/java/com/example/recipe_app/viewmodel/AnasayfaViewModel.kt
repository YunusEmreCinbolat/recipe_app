package com.example.recipe_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.data.repo.YemeklerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yemekrepo:YemeklerDaRepository):ViewModel() {
    var yemeklistesi=MutableLiveData<List<Yemek>>()
    init {
        tumYemek()
        yemeklistesi=yemekrepo.yemekGetir()
    }
    fun yemekAra(arananYemek:String){
        yemekrepo.yemekAra(arananYemek)
    }
    fun yemekSil(yemekId: Int,yemekAd: String,yemekTanim: String){
        yemekrepo.yemekSil(yemekId, yemekAd = yemekAd,yemekTanim)
    }
    fun tumYemek(){
        yemekrepo.tumYemek()
    }

}