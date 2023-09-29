package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            binding.apply {
                toolbarGuncelle.title = "${yemekDetayList.name} Güncelle"
                editTextyemekAdi.setText( yemekDetayList.name)
                editTextTextTarif.setText(yemekDetayList.description)
            }
        }

        binding.buttonYemekGuncelle.setOnClickListener {
            val alert = AlertDialog.Builder(requireContext())
            alert.setTitle("Güncelleme")

            val yemekAd=binding.editTextyemekAdi.text.trim().toString()
            val yemekTarif=binding.editTextTextTarif.text.trim().toString()

            if(!yemekAd.equals("") && !yemekTarif.equals("") ) {
                alert.setMessage("${yemekAd.uppercase()} Güncellensin mi ?")

                alert.setPositiveButton("EVET") { dialog, which ->

                    val yemek=Yemek(gelenYemek,yemekAd,yemekTarif)
                    guncelle(yemek)

                    Toast.makeText(
                        requireContext(),
                        "${yemekAd.uppercase()} Güncellendi",
                        Toast.LENGTH_LONG
                    ).show()
                }
                alert.setNegativeButton("HAYIR") { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        "${yemekAd.uppercase()} Güncellenmedi",
                        Toast.LENGTH_LONG
                    ).show()
                }
                alert.show()
            } else {
                Toast.makeText(requireContext(),"Alanlar Boş Geçilemez", Toast.LENGTH_LONG).show()
            }
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