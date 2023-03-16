package com.example.domain.model

import java.io.Serializable

data class RecipeItem(
    val id: Int = 0,
    val name: String,
    val image: String

): Serializable