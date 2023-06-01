package com.azkifairuz.myapplication.data

import com.azkifairuz.myapplication.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NewsService @Inject constructor(private val newsApi: NewsApiService) {

    suspend fun getNews(): List<NewsModel> {

        return withContext(Dispatchers.IO) {
            val news = newsApi.getTopHeadlines()
            news.body() ?: emptyList()
        }
    }
}