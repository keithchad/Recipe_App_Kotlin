package com.chad.foodrecipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chad.foodrecipeapp.converter.CategoryListConverter
import com.chad.foodrecipeapp.converter.MealListConverter
import com.chad.foodrecipeapp.dao.RecipeDao
import com.chad.foodrecipeapp.model.*

@Database(entities = [ Recipe::class, Category::class, CategoryItems::class, Meal::class, MealItems::class], version = 1, exportSchema = false)
@TypeConverters( CategoryListConverter::class, MealListConverter::class )
abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        var recipeDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context) : RecipeDatabase {
            if (recipeDatabase == null) {
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