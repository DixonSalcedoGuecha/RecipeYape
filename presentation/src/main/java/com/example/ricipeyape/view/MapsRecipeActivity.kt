package com.example.ricipeyape.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.model.RecipeItem
import com.example.domain.utils.Constants
import com.example.ricipeyape.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsRecipeActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private var nameRecipe: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_recipe)
        val getBundle = intent.extras
        var recipeItem: RecipeItem? = null

        if (getBundle != null) {

            recipeItem = getBundle.getSerializable(Constants.KEY_SEND_MAP) as RecipeItem?
            nameRecipe = recipeItem?.name.toString()
        }
        createFragment()
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val coordinate = LatLng(5.761624379021569, -72.90653429911457)
        val marker = MarkerOptions().position(coordinate).title(nameRecipe)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinate, 19f), 5000, null
        )
    }
}