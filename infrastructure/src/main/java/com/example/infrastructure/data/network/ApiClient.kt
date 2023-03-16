package com.example.infrastructure.data.network

import com.example.domain.utils.Constants.TOKEN
import com.example.infrastructure.data.model.ApiResponse
import com.example.infrastructure.data.model.IngredientsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("/recipes/complexSearch?apiKey=$TOKEN")
    suspend fun getAllRecipe(): ApiResponse

    @GET("recipes/{id}/ingredientWidget.json?apiKey=$TOKEN")
    suspend fun getIngredientsRecipe(@Query("id") id: Int): IngredientsResponse

}