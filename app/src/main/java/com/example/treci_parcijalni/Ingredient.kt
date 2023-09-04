package com.example.treci_parcijalni

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient_item")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)

    val name:String,
    val caloriesNum:Int,
)