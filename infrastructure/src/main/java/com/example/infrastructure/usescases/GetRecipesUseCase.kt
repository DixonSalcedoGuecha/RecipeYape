package com.example.infrastructure.usescases

import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.entities.toDataBase
import com.example.infrastructure.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesUseCase  @Inject constructor(
    private val repository : RecipeRepository
) {

    suspend operator fun invoke (): List<RecipeItem> {
        var recipe = repository.getAllRecipeFromDataBase()

        return recipe.ifEmpty {
            recipe = repository.getAllRecipeFromApi()
            repository.insertRecipe(recipe.map { it.toDataBase() })
            recipe
        }

    }
}