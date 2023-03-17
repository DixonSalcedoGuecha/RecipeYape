package com.example.infrastructure

import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.domain.model.SummaryItems
import com.example.infrastructure.data.database.entities.IngredientsEntity
import com.example.infrastructure.data.database.entities.RecipeEntity
import com.example.infrastructure.data.database.entities.SummaryEntity
import com.example.infrastructure.data.model.ItemsResponse
import com.example.infrastructure.data.model.RecipeResponse
import com.example.infrastructure.data.model.SummaryResponse

fun RecipeResponse.toDomain() = RecipeItem(id, title, image)
fun RecipeEntity.toDomain() = RecipeItem(id, name, image)
fun IngredientsEntity.toDomain() = IngredientsItems(id = id, name = name, amount = amount.toString())
fun ItemsResponse.toDomain(id: Int) = IngredientsItems(
    id = id,
    name = name,
    amount = amount.metric.value.toString() + " " + amount.metric.unit
)
fun SummaryResponse.toDomain1(id: Int) = SummaryItems(id = id, title = title, summary = summary)
fun SummaryEntity.toDomain2() = SummaryItems(id = id, title = title, summary = summary)