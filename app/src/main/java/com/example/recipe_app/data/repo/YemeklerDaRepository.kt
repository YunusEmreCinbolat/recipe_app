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
    fun yemekKayit(Value:String, Description:String){
        yemekDao.yemekEkle(Value,Description).enqueue(object :Callback<CRUDsonuc>{
            override fun onResponse(call: Call<CRUDsonuc>, response: Response<CRUDsonuc>) {
                val message=response.body()?.message
                Log.e("EKLE",message.toString())
                tumYemek()
            }

            override fun onFailure(call: Call<CRUDsonuc>, t: Throwable) {
            }

        })
    }
    fun yemekGuncelle(id:Int, name:String, description:String){
        yemekDao.yemekGuncelle(id,name,description).enqueue(object :Callback<CRUDsonuc>{
            override fun onResponse(call: Call<CRUDsonuc>, response: Response<CRUDsonuc>) {
                val message=response.body()?.message
                Log.e("Guncelle",message.toString())
            }

            override fun onFailure(call: Call<CRUDsonuc>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun yemekAra(name:String){
       yemekDao.yemekAra(name).enqueue(object :Callback<YemekCevap>{
           override fun onResponse(call: Call<YemekCevap>?, response: Response<YemekCevap>) {
               val liste=response.body()?.recipes
               val message=response.body()?.message
               Log.e("Ara",message.toString())
               if (liste!=null)
                  yemeklistesi.value=liste!!
           }

           override fun onFailure(call: Call<YemekCevap>, t: Throwable) {
               TODO("Not yet implemented")
           }


       })
    }
    fun yemekSil(yemekId: Int,yemekAd: String,){
        Log.e("Sil","${yemekId} ${yemekAd} ")

    }
    fun tumYemek(){
        yemekDao.tumYemek().enqueue(object :Callback<YemekCevap>{
            override fun onResponse(call: Call<YemekCevap>?, response: Response<YemekCevap>) {
                val liste=response.body()?.recipes
                    if (liste!=null)
                        yemeklistesi.value=liste!!

            }

            override fun onFailure(call: Call<YemekCevap>, t: Throwable) {
                Log.e("YemeklerDaRepository", "İstek başarısız. Hata: ${t.message}")
            }

        })
    }
}