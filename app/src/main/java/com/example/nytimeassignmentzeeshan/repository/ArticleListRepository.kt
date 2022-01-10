package com.example.nytimeassignmentzeeshan.repository

import com.example.nytimeassignmentzeeshan.api.ArticleService
import com.example.nytimeassignmentzeeshan.model.ArticleResponse
import com.example.nytimeassignmentzeeshan.utils.Constants
import com.example.nytimeassignmentzeeshan.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class ArticleListRepository @Inject constructor(private val articleService: ArticleService):
    ArticleListRepositoryInterface {

    override suspend fun getMostPopularArticlesFromNetwork(): Resource<ArticleResponse> {
        return try {
            val response = articleService.getMostViewedArticles(Constants.API_KEY)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Resource.error",null)
            } else {
                Resource.error("Resource.error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }
}