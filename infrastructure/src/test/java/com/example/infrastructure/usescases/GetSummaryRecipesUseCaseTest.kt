package com.example.infrastructure.usescases

import com.example.infrastructure.repository.RecipeRepository
import com.example.infrastructure.repository.SummaryRecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetSummaryRecipesUseCaseTest {
    @RelaxedMockK
    private lateinit var repository : SummaryRecipeRepository

    lateinit var getSummaryRecipesUseCase: GetSummaryRecipesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getSummaryRecipesUseCase = GetSummaryRecipesUseCase(repository)
    }

    @Test
    fun `when the data base doesnt return any thing then get values from api`() = runBlocking {
        //Given
        coEvery { repository.getSummaryRecipeFromDataBase(1) } returns emptyList()

        //When
        getSummaryRecipesUseCase(1)

        //Then
        coVerify(exactly = 1) { repository.getSummaryRecipeFromApi(1) }
        coVerify(exactly = 1) { repository.insertSummaryRecipe(any()) }


    }
}