package com.example.infrastructure.usescases

import com.example.domain.model.RecipeItem
import com.example.infrastructure.repository.RecipeRepository
import javax.inject.Inject

class GetRecipeNotConnectedUseCase @Inject constructor(
    private val repository : RecipeRepository
) {

    suspend operator fun invoke (): List<RecipeItem> {
        val recipe = repository.getAllRecipeFromDataBase()
        return   recipe.map { it }

    }
}