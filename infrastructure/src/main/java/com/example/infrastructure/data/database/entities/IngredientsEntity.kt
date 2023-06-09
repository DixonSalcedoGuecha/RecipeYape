package com.example.infrastructure.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.IngredientsItems

@Entity(tableName = "ingredients_table")
data class IngredientsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idKey") val idKey: Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "amount") val amount: String)

fun IngredientsItems.toDataBase() = IngredientsEntity(id = id, name = name, amount = amount)
