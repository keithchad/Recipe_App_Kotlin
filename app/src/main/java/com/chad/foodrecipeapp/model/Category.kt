package com.chad.foodrecipeapp.model

import androidx.room.*
import com.chad.foodrecipeapp.converter.CategoryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
data class Category(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @Expose
    @SerializedName("categories")
    @ColumnInfo(name = "categories")
    @TypeConverters(CategoryListConverter::class)
    val categoryItems: List<CategoryItems>? = null
)

