package com.example.nytimeassignmentzeeshan.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nytimeassignmentzeeshan.model.Article

class ArticleItemViewModel(article: Article) {
    val title = MutableLiveData(article.title)
    val abstract = MutableLiveData(article.abstract)
    val thumb = MutableLiveData("")

    init {
        if (article.media.isNotEmpty() && article.media[0].media_metadata.isNotEmpty())
            thumb.value = article.media[0].media_metadata[0].url
        Log.d("tabi", "  ${thumb.value} ")
    }
}