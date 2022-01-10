package com.example.nytimeassignmentzeeshan.repository

import com.example.nytimeassignmentzeeshan.model.ArticleResponse
import com.example.nytimeassignmentzeeshan.utils.Resource

interface ArticleListRepositoryInterface  {
     suspend fun getMostPopularArticlesFromNetwork(): Resource<ArticleResponse>
}