package com.chad.foodrecipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chad.foodrecipeapp.model.Category
import com.chad.foodrecipeapp.model.CategoryItems
import com.chad.foodrecipeapp.model.Recipe

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM categoryitems ORDER BY id DESC")
    val getAllCategory: List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryItems: CategoryItems)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDatabase()

}