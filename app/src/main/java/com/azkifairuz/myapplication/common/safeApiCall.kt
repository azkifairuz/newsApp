package com.azkifairuz.myapplication.common

import retrofit2.Response

suspend fun <T> safeApiCall(call: suspend () -> Response<BaseResponse<T>>): ResponseState<T> {
    try {
        val response = call.invoke()
        if (response.code() in 200..209) {
            val data = (response.body()) as BaseResponse<T>
            return if(data.status == "ok") {
                ResponseState.Result(data.articles)
            }else{
                ResponseState.Error(data.status)
            }

        } else if (response.code() in 400..500) {
            return ResponseState.Error("Failed to authenticate")
        }
        return ResponseState.Error(response.message())
    } catch (e: Exception) {
        return ResponseState.Error(e.message ?: "")

    }
}