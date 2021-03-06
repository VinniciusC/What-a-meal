package com.example.vinicius.whatameal.Main

import com.example.vinicius.whatameal.Entities.Meal

interface MainContract {

    interface view{
        fun showMessage(message: String)
        fun showList(meals: List<Meal>)
        fun showProgressBar()
        fun hideProgressBar()
        fun showDetails(meal:Meal)
    }

    interface presenter{
        fun onLoadLatest()
        fun onLoadRandom()
    }
}