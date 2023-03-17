package com.example.ricipeyape.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.domain.model.IngredientsItems
import com.example.domain.model.RecipeItem
import com.example.domain.utils.Constants.KEY_SEND_MAP
import com.example.domain.utils.Constants.KEY_SEND_OBJECT
import com.example.ricipeyape.R
import com.example.ricipeyape.databinding.ActivityDetailRecipeBinding
import com.example.ricipeyape.view.adapter.IngredientRecipeAdapter
import com.example.ricipeyape.view.adapter.RecipeAdapter
import com.example.ricipeyape.viewmodel.DetailRecipeViewModel
import com.example.ricipeyape.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailRecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRecipeBinding
    private lateinit var adapter: IngredientRecipeAdapter
    private val detailViewModel: DetailRecipeViewModel by viewModels()
    private var listIngredients = emptyList<IngredientsItems>()
    private var id: Int? = 0
    private var summary: String? = ""
    lateinit var btnBack : ImageView
    lateinit var btnMaps : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnBack = findViewById(R.id.btn_back)
        btnMaps = findViewById(R.id.img_maps)

        val getBundle = intent.extras
        var recipeItem: RecipeItem? = null

        if (getBundle != null) {

            recipeItem = getBundle.getSerializable(KEY_SEND_OBJECT) as RecipeItem?
            binding.titleRecipe.text = recipeItem?.name
            Glide.with(binding.root.context).load(recipeItem?.image).into(binding.imgRecipe)
            id = recipeItem?.id
        }
        initViewModels(id ?: 0)

        initRecyclerView()

        if (recipeItem != null) {
            navigation(recipeItem)
        }


    }

    private fun navigation(recipeItem: RecipeItem) {
        btnMaps.setOnClickListener {
            val intent = Intent(this, MapsRecipeActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(KEY_SEND_MAP, recipeItem)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initViewModels(id: Int) {
        detailViewModel.onCreate(id)
        detailViewModel.onSummerDetail(id)
        detailViewModel.recipeList.observe(this, Observer {
            listIngredients = it
            initRecyclerView()
        })
        detailViewModel.summaryRecipe.observe(this, Observer {
            summary = it.toString()
            binding.summaryRecipe.text = summary
        })
        detailViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun initRecyclerView() {

        //viewEmptyList(listUsers.isEmpty())
        adapter = IngredientRecipeAdapter(listIngredients)
        binding.rcvIngredients.layoutManager = LinearLayoutManager(this)
        binding.rcvIngredients.adapter = adapter
    }
}