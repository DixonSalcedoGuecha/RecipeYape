package com.example.infrastructure.data.model

data class IngredientsResponse(
    val ingredients: List<ItemsResponse>? = emptyList(),
)
