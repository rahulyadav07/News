package com.ashish.news.ui.activity.newsactivity

import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashish.news.Base.BaseActivity
import com.ashish.news.databinding.ItemNewLayoutBinding
import com.ashish.news.utils.adjustAlpha
import com.ashish.news.utils.generateRandomColor
import com.ashish.news.utils.loadImage
import com.bumptech.glide.Glide
import com.parkzap.android.pms.fragments.cancleTicketFragment.Article

class NewsAdapter(private val articleList: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: ItemNewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.imageView.loadImage(article.urlToImage)
            binding.itemDescription.text = article.content
            binding.itemHeadline.text = article.title
            binding.itemAuther.text = "Author".plus(article.author)
            setCardBackGroundColor()
        }


        private fun setCardBackGroundColor() {
            val randomColor = generateRandomColor()

            val colorWithOpacity = adjustAlpha(randomColor, 1f)

            val shapeDrawable = ShapeDrawable()
            val outerRadii = floatArrayOf(50f, 50f, 50f, 50f, 0f, 0f, 0f, 0f)
            val roundRectShape = RoundRectShape(outerRadii, null, null)
            shapeDrawable.shape = roundRectShape

            // Set the color to the shape drawable
            shapeDrawable.paint.color = colorWithOpacity
            shapeDrawable.paint.style = Paint.Style.FILL

            binding.linearLayoutInNewActivity.background = shapeDrawable
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            ItemNewLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    fun addData(list: List<Article>) {
        articleList.addAll(list)
    }
}