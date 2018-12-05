package com.example.vinicius.whatameal.Details

import com.example.vinicius.whatameal.Entities.Meal
import com.google.android.youtube.player.YouTubePlayer

interface DetailsContract {
    interface view{
        fun showMessage(message: String)
        fun listenerPlayer(youtubePlayerInit: YouTubePlayer.OnInitializedListener)
    }
    interface presenter{
        fun initUI(meal: Meal)
    }
}