package com.example.ricipeyape.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.RecipeItem
import com.example.ricipeyape.R
import com.example.ricipeyape.view.viewholders.RecipeViewHolder

class RecipeAdapter (private var recipeItemList: List<RecipeItem>, private val onClickListener: (RecipeItem) -> Unit) : RecyclerView.Adapter<RecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return RecipeViewHolder(layoutInflater.inflate(R.layout.item_recipe ,parent, false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = recipeItemList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int  = recipeItemList.size

    fun updateRecipe(recipeList: List<RecipeItem>){
        this.recipeItemList = recipeList
        notifyDataSetChanged()
    }
}
