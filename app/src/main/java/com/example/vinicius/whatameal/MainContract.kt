package com.example.vinicius.whatameal

import com.example.vinicius.whatameal.Entities.Meal

interface MainContract {

    interface view{
        fun showMessage(message: String)
        fun showList(meals: List<Meal>)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface presenter{
        fun onLoadLatest()
    }
}