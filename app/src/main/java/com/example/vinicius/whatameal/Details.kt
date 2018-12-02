package com.example.vinicius.whatameal

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.vinicius.whatameal.Entities.Ingredient
import com.example.vinicius.whatameal.Entities.Meal
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_details.*
import android.content.Intent
import android.net.Uri


class Details : YouTubeBaseActivity() {

    companion object {
        val MEAL: String = "meal"
        val YOUTUBE_API_KEY: String = "AIzaSyBh0GZegqHSHAqUvlF46WHiHHC4uzbAHcE"
    }

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val meal = intent.getSerializableExtra(MEAL) as Meal
        val Ingredients: ArrayList<Ingredient> = ingredients(meal)

        putMeal(meal,Ingredients)
        initUI(meal)

        source.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(meal.strSource)
            startActivity(i)
        }
    }

    private fun initUI(meal: Meal) {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
                var videoID:String = meal.strYoutube.substringAfter("v=")
                youtubePlayer?.loadVideo(videoID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext,"Something went wrong", Toast.LENGTH_LONG).show()
            }

        }

        YouTubePlayer.setOnClickListener({
            YouTubePlayer.initialize(YOUTUBE_API_KEY,youtubePlayerInit)
        })
    }

    private fun putMeal(meal: Meal, ingredients:ArrayList<Ingredient>) {

        val adapter = Ingredient_adapter(this, ingredients)
        val layoutManager = LinearLayoutManager(this)

        rvIngredients.adapter = adapter
        rvIngredients.layoutManager = layoutManager

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

    fun ingredients (meal: Meal):ArrayList<Ingredient>{

        val list: ArrayList<Ingredient> = ArrayList()

        if (!meal.strIngredient1.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure1,meal.strIngredient1))
        }
        if (!meal.strIngredient2.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure2,meal.strIngredient2))
        }
        if (!meal.strIngredient3.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure3,meal.strIngredient3))
        }
        if (!meal.strIngredient4.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure4,meal.strIngredient4))
        }
        if (!meal.strIngredient5.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure5,meal.strIngredient5))
        }
        if (!meal.strIngredient6.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure6,meal.strIngredient6))
        }
        if (!meal.strIngredient6.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure6,meal.strIngredient6))
        }
        if (!meal.strIngredient7.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure7,meal.strIngredient7))
        }
        if (!meal.strIngredient8.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure8,meal.strIngredient8))
        }
        if (!meal.strIngredient9.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure9,meal.strIngredient9))
        }
        if (!meal.strIngredient10.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure10,meal.strIngredient10))
        }
        if (!meal.strIngredient11.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure11,meal.strIngredient11))
        }
        if (!meal.strIngredient12.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure12,meal.strIngredient12))
        }
        if (!meal.strIngredient13.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure13,meal.strIngredient13))
        }
        if (!meal.strIngredient14.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure14,meal.strIngredient14))
        }
        if (!meal.strIngredient15.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure15,meal.strIngredient15))
        }
        if (!meal.strIngredient16.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure16,meal.strIngredient16))
        }
        if (!meal.strIngredient17.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure17,meal.strIngredient17))
        }
        if (!meal.strIngredient18.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure18,meal.strIngredient18))
        }
        if (!meal.strIngredient19.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure19,meal.strIngredient19))
        }
        if (!meal.strIngredient20.isNullOrBlank()){
            list.add(Ingredient(meal.strMeasure20,meal.strIngredient20))
        }
        return list
    }

}
