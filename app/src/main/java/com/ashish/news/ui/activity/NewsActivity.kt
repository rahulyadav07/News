package com.ashish.news.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ashish.news.Base.BaseActivity
import com.ashish.news.Base.UiState
import com.ashish.news.R
import com.ashish.news.ui.viewmodel.NewsViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

class NewsActivity : BaseActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news)

        setUpObserver()
    }

    private fun setUpObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            Log.d("rahul", "setUpObserver: ${Gson().toJson(it.data)}")

                        }
                        is UiState.Loading -> {

                        }
                        is UiState.Error -> {
                            //Handle Error
                            Log.d("rahul", "setUpObserver errir: ${Gson().toJson(it.message)}")

                            Toast.makeText(this@NewsActivity, it.message, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }
}