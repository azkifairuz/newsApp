package com.azkifairuz.myapplication.domain

import com.azkifairuz.myapplication.common.ResponseState
import com.azkifairuz.myapplication.domain.item.NewsItem
import com.azkifairuz.myapplication.domain.item.toNewsItem
import com.azkifairuz.myapplication.repo.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsUseCase @Inject() constructor(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(): Flow<List<NewsItem>> = flow {
        newsRepository.getNews().collect {
            when (it) {
                is ResponseState.Error -> emit(listOf())
                ResponseState.Loading -> emit(listOf())
                is ResponseState.Result -> it.data.map { data -> data.toNewsItem() }.shuffled()
                    .let { item ->
                        emit(item)
                    }

            }
        }
    }
}