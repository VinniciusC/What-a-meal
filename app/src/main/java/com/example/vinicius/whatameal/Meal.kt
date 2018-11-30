package com.example.vinicius.whatameal

data class Meal(val name: String,
                val id: Int,
                val category: String,
                val area: String,
                val youtube: String,
                val instructions: List<String>,
                val measure: List<String>,
                val thumbnail: String) {
}