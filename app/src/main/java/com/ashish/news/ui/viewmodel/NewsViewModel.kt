package com.ashish.news.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ashish.news.data.api.OkHttpClient
import com.ashish.news.data.repository.NewsRepo
import androidx.lifecycle.viewModelScope
import com.ashish.news.Base.UiState
import com.google.gson.Gson
import com.parkzap.android.pms.fragments.cancleTicketFragment.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException


class NewsViewModel : ViewModel() {

    private val okHttpClient = OkHttpClient
    private val repo = NewsRepo(okHttpClient)

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        CoroutineScope(Dispatchers.IO).launch {
            try {

                repo.fetchNews().collect {
                    Log.d("rahul", "fetchNews: ${Gson().toJson(it)}")
                    _uiState.value = UiState.Success(it.articles)
                }
            } catch (e: IOException) {
                _uiState.value = UiState.Error(e.message ?: "Sorry not able to fetch the data.")
            }
        }
    }
}