package com.ashish.news.data.repository

import com.ashish.news.data.api.OkHttpClient
import com.ashish.news.data.model.News
import com.parkzap.android.pms.fragments.cancleTicketFragment.Article
import kotlinx.coroutines.flow.flow
import java.io.IOException
import kotlinx.coroutines.flow.Flow



class NewsRepo(private val okHttpClient: OkHttpClient) {

    @Throws(IOException::class)
    suspend fun fetchNews(): Flow<News> {
        return flow {
            okHttpClient.fetchData()
        }
    }
}