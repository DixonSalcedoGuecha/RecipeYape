package com.example.infrastructure

import com.example.domain.model.RecipeItem
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.model.RecipeResponse

fun RecipeResponse.toDomain() = RecipeItem(id, title,image)
fun RecipeEntity.toDomain() = RecipeItem(id, name, image )