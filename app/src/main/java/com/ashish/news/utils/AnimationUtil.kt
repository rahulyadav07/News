package com.ashish.news.utils

import android.graphics.Color
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import kotlin.random.Random

fun View.slideToRight(screenWidth: Int) {


    val animation = TranslateAnimation(screenWidth.toFloat(), 0f, 0f, 0f)
    animation.duration = 1000
    animation.fillAfter = true

    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {
        }

        override fun onAnimationRepeat(animation: Animation?) {}
    })

    this.startAnimation(animation)
}


 fun generateRandomColor(): Int {
    val red = Random.nextInt(150, 256)
    val green = Random.nextInt(150, 256)
    val blue = Random.nextInt(150, 256)
    return Color.rgb(red, green, blue)
}

fun adjustAlpha(color: Int, factor: Float): Int {
    val alpha = (Color.alpha(color) * factor).toInt()
    val red = Color.red(color)
    val green = Color.green(color)
    val blue = Color.blue(color)
    return Color.argb(alpha, red, green, blue)
}