package com.example.ricipeyape.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.RecipeItem
import com.example.ricipeyape.databinding.ItemRecipeBinding

class RecipeViewHolder ( view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemRecipeBinding.bind(view)

    fun render (recipeItem: RecipeItem, onClickListener: (RecipeItem) -> Unit){
        with(binding){
            nameUser.text = recipeItem.name
           Glide.with(binding.root.context).load(recipeItem.image).into(imgRecipe)

            itemView.setOnClickListener { onClickListener(recipeItem) }
        }

    }
}