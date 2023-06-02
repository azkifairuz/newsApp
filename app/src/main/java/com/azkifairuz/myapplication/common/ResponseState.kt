package com.azkifairuz.myapplication.common

sealed class ResponseState<out R> {
    object Loading:ResponseState<Nothing>()
    data class Result<out Result>(val data:Result):ResponseState<Result>()
    data class Error(val message:String=""):ResponseState<Nothing>()
}