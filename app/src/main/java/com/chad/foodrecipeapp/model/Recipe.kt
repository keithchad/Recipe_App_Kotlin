package com.chad.foodrecipeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipes")
data class Recipe (

        @PrimaryKey(autoGenerate = true)
        var id: Int

)