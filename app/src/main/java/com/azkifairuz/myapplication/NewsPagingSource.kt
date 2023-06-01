package com.azkifairuz.myapplication

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.azkifairuz.myapplication.data.NewsModel
import com.azkifairuz.myapplication.data.NewsApiService

class NewsPagingSource(private val newsApiService: NewsApiService) : PagingSource<Int, NewsModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsModel> {
        try {
            val page = params.key ?: 1
            val response = newsApiService
                .getTopHeadlines()
            if (response.isSuccessful) {
                val newsList = response.body()?.article ?: "asiii"

                Log.e("coba", "load: $newsList")
                return LoadResult.Page(data = newsList, prevKey = prevKey, nextKey = nextKey)
            } else {
                return LoadResult.Error(Exception("Failed to fetch news: ${response.code()}"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewsModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

