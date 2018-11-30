package com.example.vinicius.whatameal

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater

class Meals_adapter(val meals: List<Meal>)
    : RecyclerView.Adapter<Meals_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meals_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(meals[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(meal: Meal) {
//            itemView.tvNome.text = contatinhoNome
        }

    }
}