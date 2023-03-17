package com.example.infrastructure.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.SummaryItems
import com.example.infrastructure.data.database.entities.IngredientsEntity
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.database.entities.SummaryEntity

@Dao
interface SummaryRecipeDao {
    @Query("SELECT * FROM summary_table WHERE id LIKE :id")
    suspend fun getSummaryRecipesDataBase(id: Int) : List<SummaryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSummary(summary: List<SummaryEntity>)
}