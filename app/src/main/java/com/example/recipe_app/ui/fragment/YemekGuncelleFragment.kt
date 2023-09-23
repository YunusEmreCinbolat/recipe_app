package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recipe_app.R
import com.example.recipe_app.databinding.FragmentYemekGuncelleBinding


class YemekGuncelleFragment : Fragment() {
    private lateinit var binding: FragmentYemekGuncelleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentYemekGuncelleBinding.inflate(inflater,container,false)
        binding.toolbarKayit.title="Yemek Kayıt Ekranı"
        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek=bundle.yemek
        binding.editTextyemekAdi.setText(gelenYemek.name)
        binding.editTextTextTarif.setText(gelenYemek.description)
        binding.buttonYemekGuncelle.setOnClickListener {
            val yemekAd=binding.editTextyemekAdi.text.trim().toString()
            val yemekTarif=binding.editTextTextTarif.text.trim().toString()
            guncelle(gelenYemek.id,yemekAd,yemekTarif)
        }
        return binding.root
    }
    fun guncelle(yemekId:Int, yemekAd:String,yemekTanim:String){

    }

}