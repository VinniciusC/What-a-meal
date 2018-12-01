package com.example.vinicius.whatameal.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createMealsService() = retrofit.create(MealsServices::class.java)

}