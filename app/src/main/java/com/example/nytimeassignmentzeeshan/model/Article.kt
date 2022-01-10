package com.example.nytimeassignmentzeeshan.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    val abstract: String,
    @SerializedName("adx_keywords")
    val adx_keywords: String,
    @SerializedName("asset_id")
    val asset_id: Long,
    val byline: String,
    val column: Any,
    val des_facet: List<String>,
    val eta_id: Int,
    val geo_facet: List<String>,
    val id: Long,
    val media: List<Media>,
    val nytdsection: String,
    val org_facet: List<Any>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
) : Serializable