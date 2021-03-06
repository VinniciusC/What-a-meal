package com.example.vinicius.whatameal.Details

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.vinicius.whatameal.Entities.Ingredient
import com.example.vinicius.whatameal.R
import kotlinx.android.synthetic.main.ingredient_item.view.*

class Ingredient_adapter(val context: Context, val ingredients: List<Ingredient>)
    : RecyclerView.Adapter<Ingredient_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredients.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(ingredients[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(ingredient: Ingredient) {
            itemView.ingredient.text = ingredient.ingredient
            itemView.measure.text = ingredient.measure
        }

    }
}