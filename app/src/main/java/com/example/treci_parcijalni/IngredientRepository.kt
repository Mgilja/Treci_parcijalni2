package com.example.treci_parcijalni

import androidx.lifecycle.LiveData

class IngredientRepository(private val ingredientDao:IngredientDao) {
     val allIngredients:LiveData<List<Ingredient>> = ingredientDao.getAllIngredients()

     suspend fun insert(ingredient: Ingredient) {
         ingredientDao.insertIngredient(ingredient)

     }

    suspend fun delete(ingredient: Ingredient) {
        ingredientDao.deleteIngredient(ingredient)
    }
}