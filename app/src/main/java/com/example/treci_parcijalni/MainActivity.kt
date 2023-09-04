package com.example.treci_parcijalni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var caloriesNum: EditText
    private lateinit var buttonSave: Button
    private lateinit var recylerView: RecyclerView
    private lateinit var ingredientViewMode: IngredientViewModel
    private lateinit var ingredientAdapter: IngredientsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.ingredientName)
        caloriesNum = findViewById(R.id.caloriesNumber)
        buttonSave = findViewById(R.id.buttonSave)
        recylerView = findViewById(R.id.recyclerView)
        recylerView.adapter = ingredientAdapter

        recylerView.layoutManager = LinearLayoutManager(this)


        ingredientViewMode = ViewModelProvider(
            this,
            IngredientViewModelFactory(application)
        ).get(IngredientViewModel::class.java)

         buttonSave.setOnClickListener { saveIngredient() }

    }

    private fun saveIngredient(): Boolean {
        val name = editTextName.text.toString().trim()
        val caloriesString = caloriesNum.text.toString().trim()


        val calories = caloriesString.toInt()
        val ingredient = Ingredient(name = name, caloriesNum = calories)
        ingredientViewMode.insert(ingredient)

        editTextName.text.clear()
        caloriesNum.text.clear()


        return true

    }

    private fun deleteIngredientConfirm(ingredient: Ingredient) {


    }

    private fun deleteIngredient(ingredient: Ingredient) {
           ingredientViewMode.delete(ingredient)
    }
}