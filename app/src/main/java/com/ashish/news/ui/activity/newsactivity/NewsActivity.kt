package com.ashish.news.ui.activity.newsactivity

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ashish.news.Base.BaseActivity
import com.ashish.news.Base.UiState
import com.ashish.news.databinding.ActivityNewsBinding
import com.ashish.news.utils.StoppableLinearLayoutManager
import com.google.gson.Gson
import kotlinx.coroutines.launch

class NewsActivity : BaseActivity() {

    private val viewModel: NewsViewModel by viewModels()

    private lateinit var  binding : ActivityNewsBinding

    private var  adapter = NewsAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setUpAdapter()
        setUpObserver()

    }

    private fun setUpAdapter() {
        val recylerView = binding.recylerView
        recylerView.layoutManager = StoppableLinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val helper = androidx.recyclerview.widget.PagerSnapHelper()
        helper.attachToRecyclerView(binding.recylerView)



        recylerView.adapter= adapter
    }

    private fun setUpObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            Log.d("rahul", "setUpObserver: ${Gson().toJson(it.data)}")
                            adapter.addData(it.data)
                            adapter.notifyDataSetChanged()
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