package com.example.infrastructure.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.RecipeItem


@Entity(tableName = "recipe_table")
data class RecipeEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val name: String,
    @ColumnInfo(name = "image") val image: String)

fun RecipeItem.toDataBase() = RecipeEntity(id, name, image)
