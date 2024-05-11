package com.ashish.news.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class StoppableLinearLayoutManager(context: Context?, orientation: Int, reverseLayout: Boolean)
    : LinearLayoutManager(context, orientation, reverseLayout) {
    var canScroll = true

    override fun canScrollVertically(): Boolean {
        return canScroll && super.canScrollVertically()
    }

    override fun canScrollHorizontally(): Boolean {
        return canScroll && super.canScrollHorizontally()
    }
}