package com.example.vinicius.whatameal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.vinicius.whatameal.Entities.Meal

import kotlinx.android.synthetic.main.activity_meals_list.*

class Meals_list : AppCompatActivity(), MainContract.view {


    val MealsList: MutableList<Meal> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_list)

        val presenter: MainContract.presenter = MainPresenter(this)
        presenter.onLoadLatest()

    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showList(meals: List<Meal>) {
        val adapter = Meals_adapter(this, meals)
        val layoutManager = LinearLayoutManager(this)
        Toast.makeText(this,meals.toString(),Toast.LENGTH_LONG).show()
        RvMeals.adapter = adapter
        RvMeals.layoutManager = layoutManager
    }

}



