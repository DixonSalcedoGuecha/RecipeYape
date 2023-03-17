package com.example.ricipeyape.view

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.RecipeItem
import com.example.domain.utils.Constants.KEY_SEND_OBJECT
import com.example.ricipeyape.view.adapter.RecipeAdapter
import com.example.ricipeyape.databinding.ActivityRecipeBinding
import com.example.ricipeyape.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityRecipeBinding
    private lateinit var adapter: RecipeAdapter
    private val recipeViewModel: RecipeViewModel by viewModels()
    private var listRecipe = emptyList<RecipeItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModels()

        binding.searchRecipe.addTextChangedListener { nameRecipe ->
            if (connectedValidate()) {
                val usersFiltered = listRecipe.filter { userFilter ->
                    userFilter.name.lowercase().contains(nameRecipe.toString().lowercase())
                }
                viewEmptyList(usersFiltered.isEmpty())
                adapter.updateRecipe(usersFiltered)
            }
        }

    }

    private fun connectedValidate() : Boolean {
        val cm = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

    private fun viewEmptyList(empty: Boolean){
       /* binding.imgEmpty.isVisible = empty
        binding.txtEmpty.isVisible = empty*/

    }

    private fun initViewModels() {
        recipeViewModel.onCreate()
        recipeViewModel.recipeList.observe(this, Observer {
            listRecipe = it
            initRecyclerView()
        })
        recipeViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun initRecyclerView() {

        //viewEmptyList(listUsers.isEmpty())
        adapter = RecipeAdapter(listRecipe) { recipeItem -> onItemSelected(recipeItem) }
        binding.rcvRecipe.layoutManager = LinearLayoutManager(this)
        binding.rcvRecipe.adapter = adapter
    }
    private fun onItemSelected(recipeItem: RecipeItem) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(KEY_SEND_OBJECT, recipeItem)
        intent.putExtras(bundle)
        startActivity(intent)

    }

}