package com.chad.foodrecipeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CategoryItems")
class CategoryItems(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @Expose
    @SerializedName("idCategory")
    @ColumnInfo(name = "idCategory")
    val idCategory: String,

    @Expose
    @SerializedName("strCategory")
    @ColumnInfo(name = "strCategory")
    val strCategory: String,

    @Expose
    @SerializedName("strCategoryThumb")
    @ColumnInfo(name = "strCategoryThumb")
    val strCategoryThumb: String,

    @Expose
    @SerializedName("strCategoryDescription")
    @ColumnInfo(name = "strCategoryDescription")
    val strCategoryDescription: String
)


