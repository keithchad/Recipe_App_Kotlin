package com.chad.foodrecipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.foodrecipeapp.adapter.MainCategoryAdapter
import com.chad.foodrecipeapp.adapter.SubCategoryAdapter
import com.chad.foodrecipeapp.database.RecipeDatabase
import com.chad.foodrecipeapp.model.Category
import com.chad.foodrecipeapp.model.CategoryItems
import com.chad.foodrecipeapp.model.Recipe
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    var mainCategoryList = ArrayList<CategoryItems>()
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
//        mainCategoryList.add(Recipe(0, "Beef"))
//        mainCategoryList.add(Recipe(1, "Meat"))
//        mainCategoryList.add(Recipe(2, "Pork"))
//        mainCategoryList.add(Recipe(3, "Dessert"))
//
        subCategoryList.add(Recipe(0, "Beef"))
        subCategoryList.add(Recipe(1, "Meat"))
        subCategoryList.add(Recipe(2, "Pork"))
        subCategoryList.add(Recipe(3, "Dessert"))
//
//        mainCategoryAdapter.setData(mainCategoryList)
          subCategoryAdapter.setData(subCategoryList)
    }

    private fun initialize() {

        getDataFromDatabase()

        mainSubCategoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainSubCategoryRecyclerView.adapter = subCategoryAdapter

    }

    private fun getDataFromDatabase() {
        launch {
            this.let {
                val category = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                mainCategoryList = category as ArrayList<CategoryItems>
                mainCategoryList.reverse()
                mainCategoryAdapter.setData(mainCategoryList)

                mainCategoryRecyclerView.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                mainCategoryRecyclerView.adapter = mainCategoryAdapter
            }

        }
    }
}