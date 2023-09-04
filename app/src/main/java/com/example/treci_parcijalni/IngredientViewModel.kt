package com.example.treci_parcijalni

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class IngredientViewModel(application: Application):AndroidViewModel(application) {
     private val repository:IngredientRepository
     val allIngredients: LiveData<List<Ingredient>>


     init {
         val ingredietDao = IngredientDatabase.getInstance(application).ingredientDao()
          repository = IngredientRepository(ingredietDao)
          allIngredients = repository.allIngredients
     }
     fun insert(ingredient: Ingredient) = viewModelScope.launch {
          repository.insert(ingredient)


     }

     fun delete(ingredient: Ingredient) = viewModelScope.launch {
          repository.delete(ingredient)

     }
}



