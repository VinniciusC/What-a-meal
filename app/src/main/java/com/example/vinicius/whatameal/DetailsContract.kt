package com.example.vinicius.whatameal

import com.example.vinicius.whatameal.Entities.Meal

interface DetailsContract {
    interface view{
        fun showMessage(message: String)
    }
    interface presenter{
        fun initUI(meal: Meal)
    }
}