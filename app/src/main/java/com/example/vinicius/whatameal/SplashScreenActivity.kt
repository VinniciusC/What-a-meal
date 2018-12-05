package com.example.vinicius.whatameal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.vinicius.whatameal.Main.Meals_list
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
            .load(R.drawable.ic_171_512)
            .into(logo)

        Handler().postDelayed({
            val intent = Intent(this,Meals_list::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}
