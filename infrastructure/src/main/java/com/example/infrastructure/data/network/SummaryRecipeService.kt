package com.example.infrastructure.data.network

import com.example.infrastructure.data.model.RecipeResponse
import com.example.infrastructure.data.model.SummaryResponse
import com.example.infrastructure.toDomain
import com.example.infrastructure.toDomain1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SummaryRecipeService @Inject constructor(
    private val retrofit: ApiClient
) {

    suspend fun getSummaryRecipes(id: Int): List<SummaryResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getSummaryRecipe(id)
            if (response != null) {
                listOf( response)
            } else {
                emptyList()
            }
        }
    }
}

