package com.example.infrastructure.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.infrastructure.data.database.entities.IngredientsEntity
import com.example.infrastructure.data.database.entities.RecipeEntity

@Dao
interface IngredientsRecipeDao {
    @Query("SELECT * FROM ingredients_table WHERE id  LIKE :id")
    suspend fun getIngredientsRecipes(id: Int) : List<IngredientsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(ingredients: List<IngredientsEntity>)
}