package com.example.vinicius.whatameal

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_meals_list.*

class Meals_list : AppCompatActivity() {

    val MealsList: MutableList<Meal> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_list)

        val adapter = Meals_adapter(this, MealsList)
        val layoutManager = LinearLayoutManager(this)

        RvMeals.adapter = adapter
        RvMeals.layoutManager = layoutManager

    }

}



