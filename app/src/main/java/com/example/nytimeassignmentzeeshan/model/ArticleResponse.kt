package com.example.nytimeassignmentzeeshan.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    val copyright: String,
    @SerializedName("num_Results")
    val num_results: Int,
    @SerializedName("results")
    val articleList: List<Article>,
    val status: String
)


