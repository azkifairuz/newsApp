package com.azkifairuz.myapplication.data

import com.azkifairuz.myapplication.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines (
        @Query("country")
        countryCode: String = "id",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = "012ea5fc3165458b9c9188b015481f81",
    ):Response<NewsResponse>
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}