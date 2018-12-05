package com.example.vinicius.whatameal.Main

import com.example.vinicius.whatameal.Entities.Meal
import com.example.vinicius.whatameal.Entities.MealList
import com.example.vinicius.whatameal.Network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.view):
    MainContract.presenter {


    override fun onLoadLatest(){

        view.showProgressBar()
        val MealsService = RetrofitInicializer().createMealsService()

        val call = MealsService.getLatest()
        call.enqueue(object : Callback<MealList>{
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.hideProgressBar()
                view.showMessage("Connection failed")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                view.hideProgressBar()
                if (response.body() != null){
                    view.showList(response.body()!!.meals)
                }else{
                    view.showMessage("No recipes")
                }
            }

        })
    }

    override fun onLoadRandom(){
        view.showProgressBar()
        val MealsService = RetrofitInicializer().createMealsService()

        val callRandom = MealsService.getRandom()
        callRandom.enqueue(object : Callback<MealList>{
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.hideProgressBar()
                view.showMessage("Connection failed")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                view.hideProgressBar()
                if (response.body() != null){
                    val meal: Meal = response.body()!!.meals.get(0)
                    view.showDetails(meal)
                }else{
                    view.showMessage("No recipes")
                }
            }

        })
    }
}