package com.example.ricipeyape.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.ricipeyape.databinding.ItemDetailRecipeBinding
import com.example.ricipeyape.databinding.ItemRecipeBinding

class IngredientsRecipeViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemDetailRecipeBinding.bind(view)

    fun render (ingredientsItems: IngredientsItems){
        with(binding){
            nameIngredient.text = ingredientsItems.name
            amountIngredient.text = ingredientsItems.amount



        }

    }
}