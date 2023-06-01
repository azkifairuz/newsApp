package com.azkifairuz.myapplication.domain

import com.azkifairuz.myapplication.domain.item.NewsItem
import com.azkifairuz.myapplication.repo.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject() constructor(private val  newsRepository: NewsRepository) {
    suspend operator fun invoke(): List<NewsItem> {
        return newsRepository.getNews().shuffled()
    }
}