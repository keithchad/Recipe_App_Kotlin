package com.chad.foodrecipeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "MealItems")
data class MealItems(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @Expose
        @SerializedName("strMeal")
        @ColumnInfo(name = "strMeal")
        val strMeal: String,

        @Expose
        @SerializedName("strMealThumb")
        @ColumnInfo(name = "strMealThumb")
        val strMealThumb: String,

        @Expose
        @SerializedName("idMeal")
        @ColumnInfo(name = "idMeal")
        val idMeal: String,

        @SerializedName("categoryName")
        val categoryName: String
)