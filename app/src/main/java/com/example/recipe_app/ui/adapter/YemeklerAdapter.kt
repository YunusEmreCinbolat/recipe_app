package com.example.recipe_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.databinding.CardTasarimBinding
import com.example.recipe_app.ui.fragment.AnasayfaFragmentDirections
import com.example.recipe_app.util.gecisYap
import com.example.recipe_app.viewmodel.AnasayfaViewModel

class YemeklerAdapter(var mContext: Context,
                      val yemekListesi: List<Yemek>,
                    val viewModel: AnasayfaViewModel)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(binding: CardTasarimBinding):RecyclerView.ViewHolder(binding.root){
        var binding:CardTasarimBinding
        init {
            this.binding=binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
       return yemekListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek=yemekListesi.get(position)
        holder.binding.textViewListyemekAd.text=yemek.name
        holder.binding.cv.setOnLongClickListener (object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                val alert = AlertDialog.Builder(mContext)
                alert.setTitle("Silme")
                alert.setMessage("${yemek.name} silinsin mi ?")

                alert.setPositiveButton("Yes") {dialog, which ->

                    //OnClick Listener
                    viewModel.yemekSil(yemek.id,yemek.name)
                }
                alert.setNegativeButton("No") {dialog, which ->

                    //OnClick Listener
                    Toast.makeText(mContext,"${yemek.name} Silinmedi",Toast.LENGTH_LONG).show()

                }

                alert.show()

                return true
            }

        })
        holder.binding.cv.setOnClickListener {
           val gecis = AnasayfaFragmentDirections.yemekdetayGecis(yemek)
            Navigation.gecisYap(gecis,it)
        }
        holder.binding.imageViewGuncelle.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yemekguncelleGecis(yemek)
           Navigation.gecisYap(gecis,it)
        }

    }
}