package com.chad.foodrecipeapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.foodrecipeapp.R
import com.chad.foodrecipeapp.`interface`.OnItemClickListener
import com.chad.foodrecipeapp.adapter.MainCategoryAdapter
import com.chad.foodrecipeapp.adapter.SubCategoryAdapter
import com.chad.foodrecipeapp.database.RecipeDatabase
import com.chad.foodrecipeapp.model.CategoryItems
import com.chad.foodrecipeapp.model.MealItems
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    private var mainCategoryList = ArrayList<CategoryItems>()
    private var subCategoryList = ArrayList<MealItems>()

    private var mainCategoryAdapter = MainCategoryAdapter()
    private var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initialize()
        setDummyData()
    }

    private fun setDummyData() {
//        mainCategoryList.add(Recipe(0, "Beef"))
//        mainCategoryList.add(Recipe(1, "Meat"))
//        mainCategoryList.add(Recipe(2, "Pork"))
//        mainCategoryList.add(Recipe(3, "Dessert"))
//
//        subCategoryList.add(Recipe(0, "Beef"))
//        subCategoryList.add(Recipe(1, "Meat"))
//        subCategoryList.add(Recipe(2, "Pork"))
//        subCategoryList.add(Recipe(3, "Dessert"))
//
//        mainCategoryAdapter.setData(mainCategoryList)
//          subCategoryAdapter.setData(subCategoryList)
    }

    private fun initialize() {
        getDataFromDatabase()

        mainCategoryAdapter.setClickListener(onClicked)
    }

    private fun getDataFromDatabase() {
        launch {
            this.let {
                val category = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                mainCategoryList = category as ArrayList<CategoryItems>
                mainCategoryList.reverse()
                mainCategoryAdapter.setData(mainCategoryList)

                getDataFromMealsDatabase(mainCategoryList[0].strCategory)
                mainCategoryRecyclerView.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                mainCategoryRecyclerView.adapter = mainCategoryAdapter
            }

        }
    }

    private val onClicked = object : OnItemClickListener {
        override fun onClicked(categoryName: String) {
            getDataFromMealsDatabase(categoryName)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getDataFromMealsDatabase(categoryName :String) {
        textCategoryName.text = "$categoryName Category"
        launch {
            this.let {
                val meals = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecifiedMealList(categoryName)
                subCategoryList = meals as ArrayList<MealItems>
                subCategoryAdapter.setData(subCategoryList)

                mainSubCategoryRecyclerView.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                mainSubCategoryRecyclerView.adapter = subCategoryAdapter
            }

        }
    }
}