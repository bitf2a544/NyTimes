package com.example.nytimeassignmentzeeshan.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimeassignmentzeeshan.model.Article
import com.example.nytimeassignmentzeeshan.model.ArticleResponse
import com.example.nytimeassignmentzeeshan.utils.Resource
import com.example.nytimeassignmentzeeshan.repository.ArticleListRepository

import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(val repository: ArticleListRepository
) : ViewModel() {

    private val articlesResponse = MutableLiveData<Resource<ArticleResponse>>()
    val articles = MutableLiveData<List<Article>>()

    val isProgressViewVisible = MutableLiveData(false)
    val isInternetAvailable = MutableLiveData(true)

    fun fetchArticlesFromNetwork() {
        Log.e("fetchArtFromNetwork","inside")
        if(isProgressViewVisible.value != true) {
            isProgressViewVisible.value = true
            articlesResponse.value = Resource.loading(null)
            viewModelScope.launch {
                val response = repository.getMostPopularArticlesFromNetwork()
                isProgressViewVisible.postValue(false)
                if (response.data != null) {
                    articles.postValue(response.data.articleList)
                }
            }
        }
    }

}