package com.example.infrastructure.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.IngredientsItems
import com.example.domain.model.SummaryItems

@Entity(tableName = "summary_table")
data class SummaryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idKey") val idKey: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "summary") val summary: String)

fun SummaryItems.toDataBase() = SummaryEntity(id = id, title = title, summary = summary)
