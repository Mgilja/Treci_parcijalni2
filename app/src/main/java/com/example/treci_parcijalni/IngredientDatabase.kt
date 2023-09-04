package com.example.treci_parcijalni

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ingredient::class], version = 1)
abstract class IngredientDatabase:RoomDatabase() {
    abstract fun ingredientDao():IngredientDao

    companion object {
        @Volatile
        private var INSTANCE:IngredientDatabase? = null

        fun getInstance(context: Context):IngredientDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
            }
        }

        private fun buildDatabase(context: Context): IngredientDatabase{
                return Room.databaseBuilder(
                    context.applicationContext,
                    IngredientDatabase::class.java, "igredient_databse"
                ).fallbackToDestructiveMigration().build()
        }

    }
}



