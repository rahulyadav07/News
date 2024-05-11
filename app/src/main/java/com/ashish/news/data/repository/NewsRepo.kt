package com.ashish.news.data.repository

import com.ashish.news.data.api.OkHttpClient
import com.ashish.news.data.model.News
import kotlinx.coroutines.flow.flow
import java.io.IOException
import kotlinx.coroutines.flow.Flow



class NewsRepo(private val okHttpClient: OkHttpClient) {

    @Throws(IOException::class)
    fun fetchNews(): Flow<News> {
        return flow {
          emit(okHttpClient.fetchData())
        }
    }
}