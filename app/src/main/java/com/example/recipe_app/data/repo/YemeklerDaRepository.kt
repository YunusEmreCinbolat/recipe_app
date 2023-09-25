package com.example.recipe_app.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.recipe_app.data.entity.CRUDsonuc
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.data.entity.YemekCevap
import com.example.recipe_app.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaRepository(var yemekDao: YemeklerDao) {

    var yemeklistesi:MutableLiveData<List<Yemek>>
    init {
        yemeklistesi= MutableLiveData()
    }
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
        yemekDao.tumYemek().enqueue(object :Callback<YemekCevap>{
            override fun onResponse(call: Call<YemekCevap>?, response: Response<YemekCevap>) {
                val liste= response.body()!!.yemekler

                    yemeklistesi.value=liste

            }

            override fun onFailure(call: Call<YemekCevap>, t: Throwable) {
                Log.e("YemeklerDaRepository", "İstek başarısız. Hata: ${t.message}")
            }

        })
    }
}