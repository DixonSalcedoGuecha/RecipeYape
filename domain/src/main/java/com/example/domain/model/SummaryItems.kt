package com.example.domain.model

import java.io.Serializable

data class SummaryItems(
  val id: Int = 0,
  val title: String,
  val summary: String

) : Serializable
