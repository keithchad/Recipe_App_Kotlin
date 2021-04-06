package com.chad.foodrecipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.foodrecipeapp.R
import com.chad.foodrecipeapp.model.Recipe
import kotlinx.android.synthetic.main.sub_category_item.view.*

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {

    var list = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe: Recipe = list[position]
        holder.itemView.textDishNameSub.text = recipe.dishName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(listCategory: ArrayList<Recipe>) {
        this.list = listCategory
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}