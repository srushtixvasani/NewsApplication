package com.example.newsapplication.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.R


class WelcomeScreen : AppCompatActivity()  {

    //loading time of the welcome page
    //coding tutorial : https://abhiandroid.com/programming/splashscreen
    private val SPLASH_TIME_OUT: Long = 4500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page)

        // Add video to welcome page
        val videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.splash_video)
        videoView.start()

        Handler().postDelayed({

            //after timer, the main activity will open up
            startActivity(Intent(this, MainActivity::class.java))

            // close the activity
            finish()
        }, SPLASH_TIME_OUT
        )

    }
}