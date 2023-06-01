package com.azkifairuz.myapplication.domain.item

import com.azkifairuz.myapplication.data.NewsModel


data class NewsItem(
    val id: Int,
    val title: String,
    val urlToImage: String,
    val description: String
)

fun NewsModel.toNewsItem() = NewsItem(id ,title , urlToImage ,description)
