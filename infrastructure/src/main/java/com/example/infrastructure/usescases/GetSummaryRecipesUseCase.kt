package com.example.infrastructure.usescases


import com.example.domain.model.SummaryItems
import com.example.infrastructure.data.database.entities.toDataBase
import com.example.infrastructure.repository.SummaryRecipeRepository
import javax.inject.Inject

class GetSummaryRecipesUseCase  @Inject constructor(
    private val repository : SummaryRecipeRepository
) {

    suspend operator fun invoke (id: Int): List<SummaryItems> {
        var summary = repository.getSummaryRecipeFromDataBase(id)
        return if ( summary != null ) {
            summary = repository.getSummaryRecipeFromApi(id)
            repository.insertSummaryRecipe(summary.map { it.toDataBase() })
            summary
        } else {
            summary
        }

    }
}