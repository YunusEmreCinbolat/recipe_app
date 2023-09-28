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
    var yemekDetay= MutableLiveData<Yemek>()

    init {
        tumYemek()
        yemeklistesi=yemekrepo.yemekGetir()
        yemekDetay=yemekrepo.yemekDetayGetir()
    }

    fun yemekAra(arananYemek:String){
        yemekrepo.yemekAra(arananYemek)
    }

    fun yemekSil(yemekId: Int,yemekAd: String){
        yemekrepo.yemekSil(yemekId, yemekAd = yemekAd)
    }

    fun tumYemek(){
        yemekrepo.tumYemek()
    }
}