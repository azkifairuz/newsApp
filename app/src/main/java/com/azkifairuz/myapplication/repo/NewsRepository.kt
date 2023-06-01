package com.azkifairuz.myapplication.repo

import com.azkifairuz.myapplication.data.NewsService
import com.azkifairuz.myapplication.domain.item.NewsItem
import com.azkifairuz.myapplication.domain.item.toNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService) {
    suspend fun getNews(): List<NewsItem> {
        return newsService.getNews().map {
            it.toNewsItem()
        }
    }
}