package com.example.infrastructure.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.infrastructure.data.database.entities.RecipeEntity

@Dao
interface RecipeDao{

    @Query("SELECT * FROM recipe_table")
    suspend fun getAllRecipes() : List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(recipe: List<RecipeEntity>)
}