package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recipe_app.R
import com.example.recipe_app.databinding.FragmentYemekDetayBinding


class YemekDetayFragment : Fragment() {
    private lateinit var binding: FragmentYemekDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentYemekDetayBinding.inflate(inflater,container,false)
        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek=bundle.yemek
        binding.toolbarDetay.title="${gelenYemek.name} Tarifi"
        binding.textViewyemekAd.setText(gelenYemek.name)
        binding.textViewYemektanim.setText(gelenYemek.description)
        return binding.root
    }

}