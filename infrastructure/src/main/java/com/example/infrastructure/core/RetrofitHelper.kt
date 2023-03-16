package com.example.infrastructure.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.spoonacular.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }
}