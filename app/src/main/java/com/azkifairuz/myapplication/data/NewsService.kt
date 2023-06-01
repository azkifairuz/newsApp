package com.azkifairuz.myapplication.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsService @Inject constructor(private val newsApi: NewsApiService) {

    suspend fun getNews(): List<NewsModel> {

        return withContext(Dispatchers.IO) {
            val news = newsApi.getTopHeadlines()
            news.body() ?: emptyList()
        }
    }
}