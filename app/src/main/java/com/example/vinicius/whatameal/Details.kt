package com.example.vinicius.whatameal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vinicius.whatameal.Entities.Meal
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.meals_item.view.*

class Details : AppCompatActivity() {

    companion object {
        val MEAL: String = "meal"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val meal = intent.getSerializableExtra(MEAL) as Meal
        if (meal != null){
            Title.text = meal.strMeal
            category.text = meal.strCategory
            area.text = meal.strArea
            instructions.text = meal.strInstructions

            GlideApp.with(this)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.product_image_thumbnail_placeholder)
                .centerCrop()
                .into(image)
        }
    }


}
