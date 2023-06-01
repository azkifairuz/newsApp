package com.azkifairuz.myapplication

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.azkifairuz.myapplication.data.NewsModel
import com.azkifairuz.myapplication.data.NewsApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsViewModel: ViewModel() {
    private val newsApiService = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApiService::class.java)
    val newsList: Flow<PagingData<NewsModel>> = Pager(PagingConfig(pageSize = 20)) {
        NewsPagingSource(newsApiService)
    }.flow
}
