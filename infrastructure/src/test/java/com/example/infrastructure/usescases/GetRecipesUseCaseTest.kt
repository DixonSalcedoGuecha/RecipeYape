package com.example.infrastructure.usescases

import com.example.infrastructure.repository.RecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetRecipesUseCaseTest {
    @RelaxedMockK
    private lateinit var repository : RecipeRepository

    lateinit var getRecipesUseCase: GetRecipesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRecipesUseCase = GetRecipesUseCase(repository)
    }

    @Test
    fun `when the data base doesnt return any thing then get values from api`() = runBlocking {
        //Given
        coEvery { repository.getAllRecipeFromDataBase() } returns emptyList()

        //When
        getRecipesUseCase()

        //Then
        coVerify(exactly = 1) { repository.getAllRecipeFromApi() }
        coVerify(exactly = 1) { repository.insertRecipe(any()) }


    }
}

