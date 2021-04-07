package com.chad.foodrecipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chad.foodrecipeapp.R
import com.chad.foodrecipeapp.model.CategoryItems
import com.chad.foodrecipeapp.model.Recipe
import kotlinx.android.synthetic.main.main_category_item.view.*

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.ViewHolder>() {

    var context: Context? = null
    var list = ArrayList<CategoryItems>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val categoryItems: CategoryItems = list[position]
        holder.itemView.textDishNameMain.text = categoryItems.strCategoryDescription
        Glide.with(context!!).load(categoryItems.strCategoryThumb).into(holder.itemView.imageDishMain)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(listCategory: ArrayList<CategoryItems>) {
        this.list = listCategory
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}