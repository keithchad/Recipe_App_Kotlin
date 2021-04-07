package com.chad.foodrecipeapp.converter

import androidx.room.TypeConverter
import com.chad.foodrecipeapp.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<Category>) : String? {
        val gson = Gson()
        val type = object : TypeToken<Category>() {

        }.type
        return gson.toJson(category, type)
    }

    @TypeConverter
    fun toCategoryList(categoryString : String) : List<Category>? {
        val gson = Gson()
        val type = object : TypeToken<Category>() {

        }.type
        return gson.fromJson(categoryString, type)
    }

}