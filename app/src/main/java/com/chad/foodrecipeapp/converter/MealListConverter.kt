package com.chad.foodrecipeapp.converter

import androidx.room.TypeConverter
import com.chad.foodrecipeapp.model.Category
import com.chad.foodrecipeapp.model.Meal
import com.chad.foodrecipeapp.model.MealItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealItems>) : String? {
        val gson = Gson()
        val type = object : TypeToken<Category>() {

        }.type
        return gson.toJson(category, type)
    }

    @TypeConverter
    fun toCategoryList(categoryString : String) : List<MealItems>? {
        val gson = Gson()
        val type = object : TypeToken<MealItems>() {

        }.type
        return gson.fromJson(categoryString, type)
    }

}