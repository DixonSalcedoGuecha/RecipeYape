package com.example.infrastructure.usescases

import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.entities.toDataBase
import com.example.infrastructure.repository.RecipeRepository
import com.example.infrastructure.toDomain
import javax.inject.Inject

class GetRecipesUseCase  @Inject constructor(
    private val repository : RecipeRepository
) {

    suspend operator fun invoke (): List<RecipeItem> {
        var user = repository.getAllRecipeFromDataBase()

        return user.ifEmpty {
            user = repository.getAllRecipeFromApi()
            repository.insertRecipe(user.map { it.toDataBase() })
            user
        }

    }
}