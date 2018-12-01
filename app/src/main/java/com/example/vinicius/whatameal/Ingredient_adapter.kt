package com.example.vinicius.whatameal

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater

class Ingredient_adapter(val context: Context, val ingredients: List<String>)
    : RecyclerView.Adapter<Ingredient_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredients.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context,ingredients[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,ingredient: String) {

        }

    }
}