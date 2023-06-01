package com.azkifairuz.myapplication

import androidx.paging.PagingSource
import androidx.paging.PagingState

class NewsPagingSource(private val newsApiService: NewsApiService) : PagingSource<Int, News>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        try {
            val page = params.key ?: 1
            val response = newsApiService.getTopHeadlines("id", "012ea5fc3165458b9c9188b015481f81", page, params.loadSize)
            if (response.isSuccessful) {
                val newsList = response.body()?.article ?: emptyList()
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (newsList.isNotEmpty()) page + 1 else null
                return LoadResult.Page(data = newsList, prevKey = prevKey, nextKey = nextKey)
            } else {
                return LoadResult.Error(Exception("Failed to fetch news: ${response.code()}"))
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

