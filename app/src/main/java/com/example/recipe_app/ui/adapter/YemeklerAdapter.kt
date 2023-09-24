package com.example.recipe_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.databinding.CardTasarimBinding

class YemeklerAdapter(var mContext: Context,val yemekListesi: List<Yemek>):RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {
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
                TODO("Not yet implemented")
            }

        })
        holder.binding.cv.setOnClickListener {

        }
        holder.binding.imageViewMore

    }
}