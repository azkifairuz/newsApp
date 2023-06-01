package com.azkifairuz.myapplication

data class NewsResponse(
    val article: List<News>,
    val totalResults:Int
)
