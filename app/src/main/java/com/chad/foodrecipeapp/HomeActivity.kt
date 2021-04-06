package com.chad.foodrecipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.foodrecipeapp.adapter.MainCategoryAdapter
import com.chad.foodrecipeapp.adapter.SubCategoryAdapter
import com.chad.foodrecipeapp.model.Recipe
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var mainCategoryList = ArrayList<Recipe>()
    var subCategoryList = ArrayList<Recipe>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initialize()
        setDummyData()
    }

    private fun setDummyData() {
        mainCategoryList.add(Recipe(0, "Beef"))
        mainCategoryList.add(Recipe(1, "Meat"))
        mainCategoryList.add(Recipe(2, "Pork"))
        mainCategoryList.add(Recipe(3, "Dessert"))

        subCategoryList.add(Recipe(0, "Beef"))
        subCategoryList.add(Recipe(1, "Meat"))
        subCategoryList.add(Recipe(2, "Pork"))
        subCategoryList.add(Recipe(3, "Dessert"))

        mainCategoryAdapter.setData(mainCategoryList)
        subCategoryAdapter.setData(subCategoryList)
    }

    private fun initialize() {
        mainCategoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainCategoryRecyclerView.adapter = mainCategoryAdapter

        mainSubCategoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainSubCategoryRecyclerView.adapter = subCategoryAdapter

    }
}