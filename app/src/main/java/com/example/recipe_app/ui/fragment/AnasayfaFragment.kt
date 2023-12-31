package com.example.recipe_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe_app.R
import com.example.recipe_app.data.entity.Yemek
import com.example.recipe_app.databinding.FragmentAnasayfaBinding
import com.example.recipe_app.ui.adapter.YemeklerAdapter
import com.example.recipe_app.util.gecisYap
import com.example.recipe_app.viewmodel.AnasayfaViewModel
import com.example.recipe_app.viewmodel.YemekKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.toolbarAnasayfa.title="Yemek Listesi"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        binding.rv.layoutManager=LinearLayoutManager(requireContext())

        viewModel.yemeklistesi.observe(viewLifecycleOwner){
            val adapter= YemeklerAdapter(requireContext(),it,viewModel)
            binding.rv.adapter=adapter
        }


        binding.fabEkle.setOnClickListener{
            Navigation.gecisYap(R.id.yemekkayitGecis,it)
        }

        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item=menu.findItem(R.id.ara_yemek)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
               return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)
        return binding.root
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
      viewModel.yemekAra(query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewModel.yemekAra(newText.toString())
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.tumYemek()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempView: AnasayfaViewModel by viewModels ()
        viewModel=tempView
    }
}