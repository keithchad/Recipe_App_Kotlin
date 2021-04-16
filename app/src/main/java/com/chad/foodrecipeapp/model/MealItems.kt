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

        @ColumnInfo(name = "idMeal")
        @Expose
        @SerializedName("idMeal")
        val idMeal: String,

        @SerializedName("categoryName")
        val categoryName: String,

        @Expose
        @SerializedName("strMeal")
        @ColumnInfo(name = "strMeal")
        val strMeal: String,

        @Expose
        @SerializedName("strMealThumb")
        @ColumnInfo(name = "strMealThumb")
        val strMealThumb: String,

)