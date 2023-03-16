package com.example.infrastructure.repository

import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.dao.IngredientsRecipeDao
import com.example.infrastructure.data.database.dao.RecipeDao
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.network.IngredientsRecipe
import com.example.infrastructure.data.network.RecipeService
import com.example.infrastructure.toDomain
import javax.inject.Inject

class DetailRecipeRepository @Inject constructor(
    private val api: IngredientsRecipe,
    private val recipeDao: IngredientsRecipeDao
) {

    suspend fun getDetailRecipeFromApi(id: Int): List<RecipeItem> {
        val response = api.getIngredients(id)
        return response.map { it.toDomain() }
    }

    suspend fun getDetailRecipeFromDataBase(): List<RecipeItem> {
        val response = recipeDao.getAllRecipes()
        return response.map { it.toDomain() }
    }

    suspend fun insertDetailRecipe(recipe: List<RecipeEntity>) {
        recipeDao.insertAll(recipe)

    }
}