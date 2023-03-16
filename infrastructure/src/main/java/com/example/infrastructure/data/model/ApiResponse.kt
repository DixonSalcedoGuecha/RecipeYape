package com.example.infrastructure.data.model

data class ApiResponse(
    val results: List<RecipeResponse>? = emptyList(),
    val offset: String,
    val number: Int,
    val totalResults: Int
)
