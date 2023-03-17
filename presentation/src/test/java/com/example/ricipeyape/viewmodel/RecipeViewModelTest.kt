package com.example.ricipeyape.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.RecipeItem
import com.example.infrastructure.usescases.GetRecipesUseCase
import com.example.infrastructure.usescases.GetUsersNotConnectedUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class RecipeViewModelTest {
    @RelaxedMockK
    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @RelaxedMockK
    private lateinit var getRecipeNotConnectedUseCase: GetUsersNotConnectedUseCase

    private lateinit var recipeViewModel: RecipeViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        recipeViewModel = RecipeViewModel(getRecipesUseCase, getRecipeNotConnectedUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when view model is created at the first time, get all recipes`() =
        runTest {
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

            coEvery { getRecipesUseCase() } returns recipeList

            //When
            recipeViewModel.onCreate()

            //Then
            assert(recipeViewModel.recipeList.value == recipeList.map { it })
        }
}