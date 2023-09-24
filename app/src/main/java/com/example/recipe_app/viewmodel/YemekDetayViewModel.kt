package com.example.recipe_app.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipe_app.data.repo.YemeklerDaRepository

class YemekDetayViewModel: ViewModel() {
    val yemekrepo= YemeklerDaRepository()
}