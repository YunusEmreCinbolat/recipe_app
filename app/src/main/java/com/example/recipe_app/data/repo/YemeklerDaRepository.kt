package com.example.recipe_app.data.repo

import android.util.Log

class YemeklerDaRepository {
    fun yemekKayit(yemekAd:String,yemekTanim:String){
        Log.e("qewwqwe",yemekAd)
    }
    fun yemekGuncelle(yemekId:Int, yemekAd:String,yemekTanim:String){
        Log.e("guncel",yemekAd)
    }
    fun yemekAra(arananYemek:String){
        Log.e("yemek ara",arananYemek)
    }
}