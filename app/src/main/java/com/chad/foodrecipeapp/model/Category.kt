package com.chad.foodrecipeapp.model

import androidx.room.*
import com.chad.foodrecipeapp.converter.CategoryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
class Category(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "categories")
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    var categoryItems: List<CategoryItems>
)

