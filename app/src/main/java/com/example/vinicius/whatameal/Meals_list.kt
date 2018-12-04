package com.example.vinicius.whatameal

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import android.widget.Toolbar
import com.example.vinicius.whatameal.Entities.Meal

import kotlinx.android.synthetic.main.activity_meals_list.*

class Meals_list : AppCompatActivity(), MainContract.view {


    val MealsList: MutableList<Meal> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_list)

        val presenter: MainContract.presenter = MainPresenter(this)
        presenter.onLoadLatest()

        randomBtn.setOnClickListener {
            presenter.onLoadRandom()
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showList(meals: List<Meal>) {
        val adapter = Meals_adapter(this, meals)
        val layoutManager = LinearLayoutManager(this)

        adapter.configuraClick {
            showDetails(it)
        }
        RvMeals.adapter = adapter
        RvMeals.layoutManager = layoutManager
    }

    override fun showProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        ProgressBar.visibility = android.widget.ProgressBar.INVISIBLE
    }

    override fun showDetails(meal: Meal) {

        val showDetails = Intent(this,Details::class.java)
        showDetails.putExtra(Details.MEAL, meal)
        this.startActivity(showDetails)

    }

}



