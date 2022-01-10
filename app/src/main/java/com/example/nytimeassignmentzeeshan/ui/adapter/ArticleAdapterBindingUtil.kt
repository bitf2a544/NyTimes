package com.example.nytimeassignmentzeeshan.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.nytimeassignmentzeeshan.R
import com.example.nytimeassignmentzeeshan.model.Article

object ArticleAdapterBindingUtil {

    @JvmStatic
    @BindingAdapter("articleAdapter")
    fun setAdapter(recyclerView: RecyclerView, articles: List<Article>?) {
        if (recyclerView.adapter != null && articles != null) {
            val adapter = recyclerView.adapter as ArticleAdapter
            adapter.articles = articles
        }
    }

    @JvmStatic
    @BindingAdapter("loadCircleImage")
    fun loadCircleImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.drawable.ic_unknown)
                .error(R.drawable.ic_unknown)
                .transform(CircleCrop())
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("bannerImage")
    fun bannerImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.drawable.ic_unknown)
                .error(R.drawable.ic_unknown)
                .into(imageView)
        }
    }
}