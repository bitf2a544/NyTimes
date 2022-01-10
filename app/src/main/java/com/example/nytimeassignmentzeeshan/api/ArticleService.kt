package com.example.nytimeassignmentzeeshan.api

import com.example.nytimeassignmentzeeshan.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getMostViewedArticles(@Query("api-key") apiKey: String): Response<ArticleResponse>
}