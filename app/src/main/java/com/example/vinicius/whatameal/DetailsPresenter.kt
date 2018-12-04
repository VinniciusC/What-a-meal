package com.example.vinicius.whatameal

import android.widget.Toast
import com.example.vinicius.whatameal.Entities.Meal
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_details.*

class DetailsPresenter(val view: DetailsContract.view): DetailsContract.presenter {

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun initUI(meal: Meal) {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
                var videoID:String = meal.strYoutube.substringAfter("v=")
                youtubePlayer?.loadVideo(videoID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                view.showMessage("Something went wrong")
            }

        }

        YouTubePlayer.setOnClickListener({
            YouTubePlayer.initialize(Details.YOUTUBE_API_KEY,youtubePlayerInit)
        })
    }
}