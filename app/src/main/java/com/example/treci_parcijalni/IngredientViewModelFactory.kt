package com.example.treci_parcijalni

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IngredientViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IngredientViewModel::class.java)) {

            return IngredientViewModel(application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}