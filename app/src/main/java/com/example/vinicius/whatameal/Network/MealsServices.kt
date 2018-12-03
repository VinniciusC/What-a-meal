package com.example.vinicius.whatameal.Network

import retrofit2.Call
import com.example.vinicius.whatameal.Entities.MealList
import retrofit2.http.GET

interface MealsServices {

    companion object {
        private const val apiKey = 1
    }
    @GET("$apiKey/latest.php")
    fun getLatest(): Call<MealList>

    @GET("$apiKey/random.php")
    fun getRandom(): Call<MealList>
}