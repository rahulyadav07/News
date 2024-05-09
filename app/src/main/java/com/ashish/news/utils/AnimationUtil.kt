package com.ashish.news.utils

import android.animation.Animator
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

fun View.slideToRight(screenWidth :Int) {



    val animation = TranslateAnimation(screenWidth.toFloat(), 0f, 0f, 0f)
    animation.duration = 1000 // Set animation duration in milliseconds
    animation.fillAfter = true // Keep the TextView in its final position after animation

    // Set an animation listener to handle animation events
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {
            // Animation ended, do any necessary cleanup or post-animation tasks
        }

        override fun onAnimationRepeat(animation: Animation?) {}
    })

    // Start the animation
    this.startAnimation(animation)
}
