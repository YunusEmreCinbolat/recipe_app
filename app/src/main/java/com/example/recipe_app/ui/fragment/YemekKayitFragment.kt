package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipe_app.R
import com.example.recipe_app.databinding.FragmentYemekKayitBinding
import com.example.recipe_app.viewmodel.YemekGuncelleViewModel
import com.example.recipe_app.viewmodel.YemekKayitViewModel


class YemekKayitFragment : Fragment() {
    private lateinit var binding: FragmentYemekKayitBinding
    private lateinit var viewModel: YemekKayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentYemekKayitBinding.inflate(inflater,container,false)
        binding.toolbarKayit.title="Yemek kayıt ekranı"
        binding.buttonYemekKaydet.setOnClickListener {
            val yemekAd=binding.editTextyemekAdi.text.trim().toString()
            val yemekTarif=binding.editTextTextTarif.text.trim().toString()
            kayit(yemekAd,yemekTarif)
        }
        return binding.root
    }
    fun kayit(yemekAd:String,yemekTanim:String){}

}