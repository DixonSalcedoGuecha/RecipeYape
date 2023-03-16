package com.example.infrastructure.data.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    val id: Int,
    val title: String,
    val image: String
)
