package com.example.vinicius.whatameal.Main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.vinicius.whatameal.Entities.Meal
import com.example.vinicius.whatameal.GlideApp
import com.example.vinicius.whatameal.R
import kotlinx.android.synthetic.main.meals_item.view.*

class Meals_adapter(val context: Context, val meals: List<Meal>)
    : RecyclerView.Adapter<Meals_adapter.ViewHolder>() {

    var click: ((meal:Meal)->Unit)? = null

    fun configuraClick(click: ((meal:Meal)->Unit)?){
        this.click = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meals_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context,meals[position],click)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,meal: Meal, click: ((meal:Meal)->Unit)?) {

            itemView.mealName.text = meal.strMeal
            itemView.mealCategory.text = meal.strCategory

            GlideApp.with(context)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.product_image_thumbnail_placeholder)
                .centerCrop()
                .into(itemView.mealImage)
            if (click != null) {
                itemView.setOnClickListener {
                    click.invoke(meal)
                }
            }
        }
    }
}