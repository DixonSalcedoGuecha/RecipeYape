package com.example.infrastructure.data.network

import com.example.infrastructure.data.model.ItemsResponse
import com.example.infrastructure.data.model.RecipeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IngredientsRecipe @Inject constructor(
    private val retrofit: ApiClient
) {

    suspend fun getIngredients(id: Int): List<ItemsResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getIngredientsRecipe(id = id)

            if (!response.ingredients.isNullOrEmpty()) {
                response.ingredients.map { it }
            } else {
                emptyList()
            }
        }
    }
}