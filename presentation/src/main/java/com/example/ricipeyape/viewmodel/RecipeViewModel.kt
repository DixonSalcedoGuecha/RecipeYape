package com.example.ricipeyape.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.RecipeItem
import com.example.infrastructure.usescases.GetRecipesUseCase
import com.example.infrastructure.usescases.GetRecipeNotConnectedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecipeViewModel @Inject constructor(
    var getRecipesUseCase: GetRecipesUseCase,
    var getRecipeNotConnectedUseCase: GetRecipeNotConnectedUseCase
) : ViewModel() {

    val recipeList = MutableLiveData<List<RecipeItem>>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRecipesUseCase()
            if (result.isNotEmpty()){
                recipeList.postValue(result)
                isLoading.postValue(false)
            } else {
                recipeList.postValue(emptyList())
                isLoading.postValue(false)
            }
        }

    }

    fun withoutConnection(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRecipeNotConnectedUseCase()
            if (result.isNotEmpty()){
                recipeList.postValue(result.map { it })
                isLoading.postValue(false)
            } else {
                recipeList.postValue(emptyList())
                isLoading.postValue(false)
            }
        }

    }

}