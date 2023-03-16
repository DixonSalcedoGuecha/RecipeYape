package com.example.infrastructure.data.network

import com.example.infrastructure.data.model.RecipeResponse
import com.example.infrastructure.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeService @Inject constructor(
    private val retrofit: ApiClient
) {

    suspend fun getRecipes(): List<RecipeResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getAllRecipe()

            if (!response.results.isNullOrEmpty()) {
                response.results.map { it }
            } else {
                emptyList()
            }
        }
    }
}

