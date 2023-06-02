package com.azkifairuz.myapplication.common

import com.azkifairuz.myapplication.domain.item.NewsResponse

data class BaseResponse<T>(
    val status: String,
    val totalResults: Long,
    val articles: T
)
