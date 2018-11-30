package com.example.vinicius.whatameal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.meals_item.view.*

class Meals_adapter(val context: Context, val meals: List<Meal>)
    : RecyclerView.Adapter<Meals_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meals_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context,meals[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,meal: Meal) {
            itemView.mealName.text = meal.name
            itemView.mealCategory.text = meal.category

            GlideApp.with(context)
                .load(meal.thumbnail)
                .placeholder(R.drawable.product_image_thumbnail_placeholder)
                .centerCrop()
                .into(itemView.mealImage)


        }

    }
}