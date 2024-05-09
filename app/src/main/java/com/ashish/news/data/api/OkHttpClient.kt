package com.ashish.news.data.api

import com.ashish.news.utils.BASE_URl
import com.google.gson.Gson
import com.ashish.news.data.model.News

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object OkHttpClient {

    private val client = OkHttpClient()

    fun fetchData():Any {
        val request = Request.Builder()
            .url(BASE_URl)
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val responseData = response.body?.string()

            return parseData(responseData)

        }

    }

    private fun parseData(responseData: String?): News {
        return Gson().fromJson(responseData, News::class.java)
    }


}
