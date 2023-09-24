package com.example.recipe_app.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.recipe_app.data.entity.Yemek

class YemeklerDaRepository {
    var yemeklistesi:MutableLiveData<List<Yemek>>
    init {
        yemeklistesi= MutableLiveData()
    }
    private lateinit var yemekListesi:ArrayList<Yemek>
    fun yemekGetir():MutableLiveData<List<Yemek>>{
        return yemeklistesi
    }
    fun yemekKayit(yemekAd:String,yemekTanim:String){
        Log.e("qewwqwe",yemekAd)
    }
    fun yemekGuncelle(yemekId:Int, yemekAd:String,yemekTanim:String){
        Log.e("guncel",yemekAd)
    }
    fun yemekAra(arananYemek:String){
        Log.e("yemek ara",arananYemek)
    }
    fun yemekSil(yemekId: Int,yemekAd: String,yemekTanim: String){
        Log.e("Sil","${yemekId} ${yemekAd} -${yemekTanim}")

    }
    fun tumYemek(){
        yemekListesi=ArrayList()
        val y1= Yemek(1,"Kruvasan","Çikolata")
        val y2= Yemek(2,"Kruvasa","Çikolata")
        val y3= Yemek(3,"Kruvan","Çikolata")
        val y4= Yemek(4,"Kasan","Çikolata")
        yemekListesi.add(y1)
        yemekListesi.add(y2)
        yemekListesi.add(y3)
        yemekListesi.add(y4)
        yemeklistesi.value=yemekListesi
    }
}