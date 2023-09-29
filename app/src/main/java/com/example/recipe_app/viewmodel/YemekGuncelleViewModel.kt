package com.example.recipe_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.data.repo.YemeklerDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.CacheRequest
import javax.inject.Inject

@HiltViewModel
class YemekGuncelleViewModel @Inject constructor(val yemekrepo:YemeklerDaRepository): ViewModel() {
    var yemekDetay= MutableLiveData<Yemek>()

    init {
        yemekDetay=yemekrepo.yemekDetayGetir()
    }

    fun yemekDetay(id:Int){
        yemekrepo.yemekDetay(id)
        Log.e("aviewmodel idddddd",id.toString())
    }

    fun yemekGuncelle(request: Yemek){
        yemekrepo.yemekGuncelle(request)
    }
}