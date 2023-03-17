package com.example.ricipeyape.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.domain.model.SummaryItems
import com.example.infrastructure.usescases.GetDetailsRecipesUseCase
import com.example.infrastructure.usescases.GetRecipesUseCase
import com.example.infrastructure.usescases.GetSummaryRecipesUseCase
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
class DetailRecipeViewModelTest{
    @RelaxedMockK
    private lateinit var getDetailsRecipesUseCase: GetDetailsRecipesUseCase

    @RelaxedMockK
    private lateinit var  getSummaryRecipesUseCase: GetSummaryRecipesUseCase

    private lateinit var detailRecipeViewModel: DetailRecipeViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        detailRecipeViewModel = DetailRecipeViewModel(getDetailsRecipesUseCase, getSummaryRecipesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when view model is created for see detail the a recipe and load the ingredients`() =
        runTest {
            //Given
            val ingredientList = listOf(
                IngredientsItems(
                    1,
                    "sea salt",
                    "1.0 tsp"
                ),
                IngredientsItems(
                    2,
                    "lemon zest",
                    "1.0 tsp"
                )
            )

            coEvery { getDetailsRecipesUseCase(1) } returns ingredientList

            //When
            detailRecipeViewModel.onCreate(1)

            //Then
            assert(detailRecipeViewModel.recipeList.value == ingredientList.map { it })
        }

    @Test
    fun `when view model is created for see detail the a recipe and load the summary`() =
        runTest {
            //Given
            val summary = listOf(
                SummaryItems(
                    1,
                    "Cannellini Bean and Asparagus Salad with Mushrooms",
                    "Cannellini Bean and Asparagus Salad with Mushrooms requires approximately <b>45 minutes"
                )
            )

            coEvery { getSummaryRecipesUseCase(1) } returns summary

            //When
            detailRecipeViewModel.onSummerDetail(1)

            //Then
            assert(detailRecipeViewModel.summaryRecipe.value == summary.first().summary)
        }

}