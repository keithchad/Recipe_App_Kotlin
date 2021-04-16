package com.chad.foodrecipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.foodrecipeapp.R
import com.chad.foodrecipeapp.model.MealItems
import com.chad.foodrecipeapp.model.Recipe
import kotlinx.android.synthetic.main.sub_category_item.view.*

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    var list = ArrayList<MealItems>()
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mealItems: MealItems = list[position]
        holder.itemView.textDishNameSub.text = mealItems.strMeal
        Glide.with(context!!).load(mealItems.strMealThumb).into(holder.itemView.imageDishSub)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(listCategory: ArrayList<MealItems>) {
        this.list = listCategory
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}