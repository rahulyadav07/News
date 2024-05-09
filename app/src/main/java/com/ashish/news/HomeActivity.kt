package com.ashish.news

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ashish.news.databinding.ActivityHomeBinding
import com.ashish.news.utils.slideToRight

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.homeScreenCardView.setCardBackgroundColor(Color.TRANSPARENT)
        hideSystemUI()
        setUpViews()
    }

    private fun setUpViews() {
        val screenWidth = resources.displayMetrics.widthPixels
        binding.apply {
            homeScreenCardTextView.slideToRight(screenWidth)
            homeScreenCenterTextView.slideToRight(screenWidth)
            homeScreenCardDescriptionTextView.slideToRight(screenWidth)
            homeScreenCta.slideToRight(screenWidth)

            /**
             * handle click here
             */

            homeScreenCta.setOnClickListener {
                // navigate to next screen from here.
            }

        }

    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
    }
}