package com.example.infrastructure.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.infrastructure.data.database.dao.IngredientsRecipeDao
import com.example.infrastructure.data.database.dao.RecipeDao
import com.example.infrastructure.data.database.dao.SummaryRecipeDao
import com.example.infrastructure.data.database.entities.IngredientsEntity
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.database.entities.SummaryEntity


@Database(entities = [RecipeEntity::class, IngredientsEntity::class, SummaryEntity::class], version = 1)
abstract class YapeDataBase : RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao
    abstract fun getIngredientRecipeDao(): IngredientsRecipeDao
    abstract fun getSummaryRecipeDao(): SummaryRecipeDao
}