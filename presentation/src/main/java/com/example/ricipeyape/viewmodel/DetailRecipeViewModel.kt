package com.example.ricipeyape.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.IngredientsItems
import com.example.infrastructure.usescases.GetDetailsRecipesUseCase
import com.example.infrastructure.usescases.GetSummaryRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailRecipeViewModel @Inject constructor(
    var getDetailsRecipesUseCase: GetDetailsRecipesUseCase,
    var getSummaryRecipesUseCase: GetSummaryRecipesUseCase
) : ViewModel() {

    val recipeList = MutableLiveData<List<IngredientsItems>>()
    val isLoading = MutableLiveData<Boolean>()
    val summaryRecipe = MutableLiveData<String>()


    fun onCreate(id: Int){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDetailsRecipesUseCase(id)
            if (result.isNotEmpty()){
                recipeList.postValue(result)
                isLoading.postValue(false)
            } else {
                recipeList.postValue(emptyList())
                isLoading.postValue(false)
            }
        }

    }

    fun onSummerDetail(id: Int){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSummaryRecipesUseCase(id)
            if (result.isNotEmpty()){
                summaryRecipe.postValue(result.first().summary)
                isLoading.postValue(false)
            } else {
                summaryRecipe.postValue("")
                isLoading.postValue(false)
            }
        }

    }

}