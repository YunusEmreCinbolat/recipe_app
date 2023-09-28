package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.recipe_app.R
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.databinding.FragmentYemekKayitBinding
import com.example.recipe_app.viewmodel.YemekGuncelleViewModel
import com.example.recipe_app.viewmodel.YemekKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

            val alert = AlertDialog.Builder(requireContext())
            alert.setTitle("Ekleme")

            val yemekAd=binding.editTextyemekAdi.text.trim().toString()
            val yemekTarif=binding.editTextTextTarif.text.trim().toString()

            if(!yemekAd.equals("") && !yemekTarif.equals("") ) {
                alert.setMessage("${yemekAd.uppercase()} eklensin mi ?")

                alert.setPositiveButton("EVET") { dialog, which ->

                    val yemek = Yemek(0, yemekAd, yemekTarif)
                    kayit(yemek)

                    Toast.makeText(
                        requireContext(),
                        "${yemekAd.uppercase()} Eklendi",
                        Toast.LENGTH_LONG
                    ).show()
                }

                alert.setNegativeButton("HAYIR") { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        "${yemekAd.uppercase()} Eklenmedi",
                        Toast.LENGTH_LONG
                    ).show()
                }
                alert.show()
            } else {
               Toast.makeText(requireContext(),"Alanlar Boş Geçilemez",Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempView:YemekKayitViewModel by viewModels ()
        viewModel=tempView
    }

    fun kayit(request:Yemek){
        viewModel.yemekKayit(request)
    }
}