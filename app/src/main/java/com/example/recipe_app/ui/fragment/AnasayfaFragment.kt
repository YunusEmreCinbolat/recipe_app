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
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.recipe_app.R
import com.example.recipe_app.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.toolbarAnasayfa.title="Yemek Listesi"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)
        binding.fabEkle.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.yemekkayitGecis)
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
        ara(query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        ara(newText.toString())
        return true
    }
    fun ara(arananYemek:String){

    }
}