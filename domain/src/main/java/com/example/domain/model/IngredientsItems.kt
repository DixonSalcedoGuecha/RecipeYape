package com.example.domain.model

import java.io.Serializable

data class IngredientsItems(
  val id: Int = 0,
  val name: String,
  val amount: String

) : Serializable
