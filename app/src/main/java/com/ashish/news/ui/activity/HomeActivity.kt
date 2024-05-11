package com.ashish.news.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.ashish.news.Base.BaseActivity
import com.ashish.news.databinding.ActivityHomeBinding
import com.ashish.news.ui.activity.newsactivity.NewsActivity
import com.ashish.news.utils.slideToRight

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.homeScreenCardView.setCardBackgroundColor(Color.TRANSPARENT)
        setUpViews()
    }

    private fun setUpViews() {
        val screenWidth = resources.displayMetrics.widthPixels
        binding.apply {
            homeScreenCardTextView.slideToRight(screenWidth)
            homeScreenCenterTextView.slideToRight(screenWidth)
            homeScreenCardDescriptionTextView.slideToRight(screenWidth)
            homeScreenCta.slideToRight(screenWidth)

            homeScreenCta.setOnClickListener {
                startActivity(Intent(this@HomeActivity, NewsActivity::class.java))
            }

        }

    }


}