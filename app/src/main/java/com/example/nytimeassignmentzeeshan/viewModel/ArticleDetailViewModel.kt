package com.example.nytimeassignmentzeeshan.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimeassignmentzeeshan.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor() : ViewModel() {
    val title = MutableLiveData("")
    val abstract = MutableLiveData("")
    val banner = MutableLiveData("")
    val source = MutableLiveData("")
    val publishDate = MutableLiveData("")

    fun setArticle(article: Article) {
        title.value = article.title
        abstract.value = article.abstract
        if (article.media.isNotEmpty() && article.media[0].media_metadata.size >= 2) {
            banner.value = article.media[0].media_metadata[2].url
        }
        source.value = "By the ${article.source}"
        publishDate.value =
            "Publish on " + article.published_date + "\t  Updated on " + article.updated
    }
}