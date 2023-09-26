package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.recipe_app.R
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.databinding.FragmentYemekGuncelleBinding
import com.example.recipe_app.viewmodel.YemekGuncelleViewModel
import com.example.recipe_app.viewmodel.YemekKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class YemekGuncelleFragment : Fragment() {
    private lateinit var binding: FragmentYemekGuncelleBinding
    private lateinit var viewModel: YemekGuncelleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentYemekGuncelleBinding.inflate(inflater,container,false)
        val bundle:YemekGuncelleFragmentArgs by navArgs()
        val gelenYemek=bundle.yemekId
        viewModel.yemekDetay(gelenYemek)
        viewModel.yemekDetay.observe(viewLifecycleOwner) { yemekDetayList ->

            // Eğer birden fazla yemek detayı dönerse, uygun olanı seçin
            binding.toolbarGuncelle.title = "${yemekDetayList.name} Güncelle"
            binding.editTextyemekAdi.setText( yemekDetayList.name)
            binding.editTextTextTarif.setText(yemekDetayList.description)
        }

        binding.buttonYemekGuncelle.setOnClickListener {
            val yemekAd=binding.editTextyemekAdi.text.trim().toString()
            val yemekTarif=binding.editTextTextTarif.text.trim().toString()
            val yemek=Yemek(gelenYemek,yemekAd,yemekTarif)
            guncelle(yemek)
        }
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempView: YemekGuncelleViewModel by viewModels ()
        viewModel=tempView
    }
    fun guncelle(request:Yemek){
        viewModel.yemekGuncelle(request)
    }

}