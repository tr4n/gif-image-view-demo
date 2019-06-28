package com.example.demoproject3.coroutine

sealed class CallResult<out T : Any> {

    class Success<out T : Any>(val data: T) : CallResult<T>()

    class Error(val exception: Throwable) : CallResult<Nothing>()

}
