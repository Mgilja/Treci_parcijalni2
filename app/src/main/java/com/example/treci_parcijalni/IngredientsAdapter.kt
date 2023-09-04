package com.example.treci_parcijalni

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngredientsAdapter(

     val onDeleteClick:(Int) -> Unit
) : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {
    private  var ingreddients  = emptyList<Ingredient>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.ingredient_item, parent, false)
        return IngredientsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val currentFoodItem = ingreddients[position]
        holder.textViewName.text = currentFoodItem.name
        holder.textViewCalories.text = currentFoodItem.caloriesNum.toString()


    }

    override fun getItemCount(): Int {
        return ingreddients.size
    }



    inner class IngredientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.ingredientName)
        val textViewCalories: TextView = itemView.findViewById(R.id.caloriesNumber)
        val deleteButton: Button = itemView.findViewById(R.id.buttonDelete)

        init {
            deleteButton.setOnClickListener {
                onDeleteClick(adapterPosition)
            }
        }
    }
}


