package com.ashish.news.data.model

import com.parkzap.android.pms.fragments.cancleTicketFragment.Article

data class News(
    val articles: List<Article>,
    val status: String
)