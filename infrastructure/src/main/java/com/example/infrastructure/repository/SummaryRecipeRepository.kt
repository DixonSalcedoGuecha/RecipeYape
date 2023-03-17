package com.example.infrastructure.repository

import com.example.domain.model.SummaryItems
import com.example.infrastructure.data.database.dao.SummaryRecipeDao
import com.example.infrastructure.data.database.entities.SummaryEntity
import com.example.infrastructure.data.network.SummaryRecipeService
import com.example.infrastructure.toDomain
import com.example.infrastructure.toDomain1
import com.example.infrastructure.toDomain2
import javax.inject.Inject

class SummaryRecipeRepository @Inject constructor(
    private val api: SummaryRecipeService,
    private val summaryRecipeDao: SummaryRecipeDao
) {

    suspend fun getSummaryRecipeFromApi(id: Int): List<SummaryItems> {
        val response = api.getSummaryRecipes(id)
        return response.map { it.toDomain1(id) }
    }

    suspend fun getSummaryRecipeFromDataBase(id: Int): List<SummaryItems> {
        val response = summaryRecipeDao.getSummaryRecipesDataBase(id)
        return response.map { it.toDomain2() }
    }

    suspend fun insertSummaryRecipe(summary: List<SummaryEntity>) {
        summaryRecipeDao.insertSummary(summary)

    }
}