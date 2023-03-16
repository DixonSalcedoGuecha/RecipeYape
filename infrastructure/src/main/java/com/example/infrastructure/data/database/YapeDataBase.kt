package com.example.infrastructure.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.infrastructure.data.database.dao.RecipeDao
import com.example.infrastructure.data.database.entities.RecipeEntity


@Database(entities = [RecipeEntity::class], version = 1)
abstract class YapeDataBase : RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao
}