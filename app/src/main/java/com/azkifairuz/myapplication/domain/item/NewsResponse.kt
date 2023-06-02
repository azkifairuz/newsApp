package com.azkifairuz.myapplication.domain.item

data class NewsResponse(
    val source: Source?,
    val author: String,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String? = null
)

data class Source (
    val id: String,
    val name: String
)

fun NewsResponse.toNewsItem() = NewsItem(source?.id.orEmpty(),author,content,title,description.orEmpty(),urlToImage.orEmpty(), publishedAt)