package com.azkifairuz.myapplication.repo

import com.azkifairuz.myapplication.common.ResponseState
import com.azkifairuz.myapplication.common.safeApiCall
import com.azkifairuz.myapplication.data.NewsApiService
import com.azkifairuz.myapplication.domain.item.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsApiService) {
    suspend fun getNews(): Flow<ResponseState<List<NewsResponse>>> = flow {
        emit(ResponseState.Loading)
        when(val result = safeApiCall { newsService.getTopHeadlines() }){
            is ResponseState.Error -> emit(result)
            ResponseState.Loading -> emit(ResponseState.Loading)
            is ResponseState.Result -> emit(ResponseState.Result(result.data))
        }

    }.flowOn(Dispatchers.IO)
}