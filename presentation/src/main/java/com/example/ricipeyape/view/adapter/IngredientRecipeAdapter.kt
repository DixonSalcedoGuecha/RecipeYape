package com.example.ricipeyape.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.ricipeyape.R
import com.example.ricipeyape.view.viewholders.IngredientsRecipeViewHolder
import com.example.ricipeyape.view.viewholders.RecipeViewHolder

class IngredientRecipeAdapter (private var ingredientsItemList: List<IngredientsItems>) : RecyclerView.Adapter<IngredientsRecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsRecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return IngredientsRecipeViewHolder(layoutInflater.inflate(R.layout.item_detail_recipe ,parent, false))
    }

    override fun onBindViewHolder(holder: IngredientsRecipeViewHolder, position: Int) {
        val item = ingredientsItemList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int  = ingredientsItemList.size


}
