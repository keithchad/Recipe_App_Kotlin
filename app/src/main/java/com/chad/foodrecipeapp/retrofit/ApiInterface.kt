package com.chad.foodrecipeapp.retrofit

import com.chad.foodrecipeapp.model.Category
import com.chad.foodrecipeapp.model.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

}