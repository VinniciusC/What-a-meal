package com.example.vinicius.whatameal

data class Meal(val name: String,
                val id: Int = 1,
                val category: String,
                val area: String = "a",
                val youtube: String = "a",
//                val instructions: List<String>,
//                val measure: List<String>,
                val thumbnail: String) {
}