package com.example.infrastructure.repository

import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.dao.IngredientsRecipeDao
import com.example.infrastructure.data.database.dao.RecipeDao
import com.example.infrastructure.data.database.entities.IngredientsEntity
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.model.ItemsResponse
import com.example.infrastructure.data.network.IngredientsRecipe
import com.example.infrastructure.data.network.RecipeService
import com.example.infrastructure.toDomain
import javax.inject.Inject

class DetailRecipeRepository @Inject constructor(
    private val api: IngredientsRecipe,
    private val ingredientsDao: IngredientsRecipeDao
) {

    suspend fun getIngredientsRecipeFromApi(id: Int): List<IngredientsItems> {
        val response = api.getIngredients(id)
        return response.map { it.toDomain(id) }
    }

    suspend fun getIngredientsRecipeFromDataBase(id: Int): List<IngredientsItems> {
        val response = ingredientsDao.getIngredientsRecipes(id)
        return response.map { it.toDomain() }
    }

    suspend fun insertIngredientsRecipe(ingredients: List<IngredientsEntity>) {
        ingredientsDao.insertAll(ingredients)

    }
}