package com.azkifairuz.myapplication

import com.azkifairuz.myapplication.data.NewsModel

data class NewsResponse(
    val article: List<NewsModel>,
    val status: String,
    val totalResults:Int
)
