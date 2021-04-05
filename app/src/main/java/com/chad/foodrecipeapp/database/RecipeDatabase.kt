package com.chad.foodrecipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chad.foodrecipeapp.dao.RecipeDao
import com.chad.foodrecipeapp.model.Recipe

@Database(entities = [ Recipe::class ], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        var recipeDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context) : RecipeDatabase {
            if (recipeDatabase != null) {
                recipeDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipeDatabase!!
        }
    }

    abstract fun recipeDao() : RecipeDao
}