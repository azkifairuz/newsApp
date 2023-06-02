package com.azkifairuz.myapplication.domain.item

import com.azkifairuz.myapplication.data.NewsModel


data class NewsItem(
    val id:String,
    val author: String,
    val content: String?,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
)

fun NewsModel.toNewsItem() = NewsItem(id.toString(),author,content,title,description,urlToImage, publishedAt)
