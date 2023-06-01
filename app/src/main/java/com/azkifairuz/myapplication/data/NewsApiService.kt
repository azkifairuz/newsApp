package com.azkifairuz.myapplication.data

import com.azkifairuz.myapplication.NewsResponse
import com.azkifairuz.myapplication.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET(Constant.TOP_HEADLINE_ENDPOINT)
    suspend fun getTopHeadlines (
        @Query("country")
        countryCode: String = "id",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constant.API_KEY,
    ):Response<List<NewsResponse>>

}