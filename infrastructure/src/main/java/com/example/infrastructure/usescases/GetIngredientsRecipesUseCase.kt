package com.example.infrastructure.usescases

import com.example.domain.model.IngredientsItems
import com.example.infrastructure.data.database.entities.toDataBase
import com.example.infrastructure.repository.DetailRecipeRepository
import javax.inject.Inject

class GetIngredientsRecipesUseCase  @Inject constructor(
    private val repository : DetailRecipeRepository
) {

    suspend operator fun invoke (id: Int): List<IngredientsItems> {
        var ingredients = repository.getIngredientsRecipeFromDataBase(id)
        return ingredients.ifEmpty {
            ingredients = repository.getIngredientsRecipeFromApi(id)
            repository.insertIngredientsRecipe(ingredients.map { it.toDataBase() })
            ingredients
        }

    }
}