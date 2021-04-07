package com.chad.foodrecipeapp.retrofit

import com.chad.foodrecipeapp.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("categories.php")
    fun getCategoryList(): Call<Category>

}