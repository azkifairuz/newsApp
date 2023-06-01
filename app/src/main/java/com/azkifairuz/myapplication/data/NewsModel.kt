package com.azkifairuz.myapplication.data


data class NewsModel(
    val id:Int,
    val author: String,
    val content: String?,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,

)
