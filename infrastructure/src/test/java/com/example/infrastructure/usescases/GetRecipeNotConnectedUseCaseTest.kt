package com.example.infrastructure.usescases

import com.example.domain.model.RecipeItem
import com.example.infrastructure.repository.RecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetRecipeNotConnectedUseCaseTest {
    @RelaxedMockK
    private lateinit var repository : RecipeRepository

    private lateinit var getRecipeNotConnectedUseCase: GetRecipeNotConnectedUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRecipeNotConnectedUseCase = GetRecipeNotConnectedUseCase(repository)
    }

    @Test
    fun `when you have no internet connection and get values from database`() = runBlocking {
        //Given
        val recipeList = listOf(
            RecipeItem(
                1,
                "Primera Receta",
                "https://spoonacular.com/recipeImages/715497-312x231.jpg"
            ),
            RecipeItem(
                2,
                "Segunda Receta",
                "https://spoonacular.com/recipeImages/716426-312x231.jpg"
            )
        )
        coEvery { repository.getAllRecipeFromDataBase() } returns recipeList

        //When
        getRecipeNotConnectedUseCase()

        //Then
        assert(getRecipeNotConnectedUseCase.invoke() == recipeList.map { it })


    }
}