package com.example.infrastructure.data.network

import com.example.domain.utils.Constants.TOKEN
import com.example.infrastructure.data.model.ApiResponse
import com.example.infrastructure.data.model.IngredientsResponse
import com.example.infrastructure.data.model.SummaryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @GET("/recipes/complexSearch?apiKey=$TOKEN")
    suspend fun getAllRecipe(): ApiResponse

    @GET("/recipes/{id}/ingredientWidget.json?apiKey=$TOKEN")
    suspend fun getIngredientsRecipe(@Path("id") id: Int): IngredientsResponse

    @GET("/recipes/{id}/summary?apiKey=$TOKEN")
    suspend fun getSummaryRecipe(@Path("id") id: Int): SummaryResponse

}