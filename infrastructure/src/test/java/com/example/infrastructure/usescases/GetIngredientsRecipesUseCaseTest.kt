package com.example.infrastructure.usescases

import com.example.domain.model.IngredientsItems
import com.example.infrastructure.repository.DetailRecipeRepository
import com.example.infrastructure.repository.RecipeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetIngredientsRecipesUseCaseTest {
    @RelaxedMockK
    private lateinit var repository : DetailRecipeRepository

    lateinit var getIngredientsRecipesUseCase: GetIngredientsRecipesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getIngredientsRecipesUseCase = GetIngredientsRecipesUseCase(repository)
    }

    @Test
    fun `when the data base doesnt return any thing then get ingredients from api`() = runBlocking {
        //Given
        coEvery { repository.getIngredientsRecipeFromDataBase(any()) } returns emptyList()

        //When
        getIngredientsRecipesUseCase(1)

        //Then
        coVerify(exactly = 1) { repository.getIngredientsRecipeFromApi(1) }
        coVerify(exactly = 1) { repository.insertIngredientsRecipe(any()) }


    }

    @Test
    fun `when the database returned the ingredients, then return them`() = runBlocking {
        //Given
        val ingredientsList = listOf(
            IngredientsItems(
                1,
                "Primer Ingrediente",
                "1.1 cup"
            ),
            IngredientsItems(
                2,
                "Segundo Ingrediente",
                "5 g"
            )
        )
        coEvery { repository.getIngredientsRecipeFromDataBase(any()) } returns ingredientsList

        //When
        val ingredients = getIngredientsRecipesUseCase(1)

        //Then
        assert(ingredients == ingredientsList)


    }
}