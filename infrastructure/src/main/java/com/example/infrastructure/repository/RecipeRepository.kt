package com.example.infrastructure.repository

import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.dao.RecipeDao
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.network.RecipeService
import com.example.infrastructure.toDomain
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeService,
    private val recipeDao: RecipeDao
) {

    suspend fun getAllRecipeFromApi(): List<RecipeItem> {
        val response = api.getRecipes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllRecipeFromDataBase(): List<RecipeItem> {
        val response = recipeDao.getAllRecipes()
        return response.map { it.toDomain() }
    }

    suspend fun insertRecipe(recipe: List<RecipeEntity>) {
        recipeDao.insertAll(recipe)

    }
}