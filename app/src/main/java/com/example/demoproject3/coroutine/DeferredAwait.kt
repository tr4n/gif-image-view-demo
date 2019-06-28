package com.example.demoproject3.coroutine

import com.example.demoproject3.data.api.response.ApiResponse
import kotlinx.coroutines.*
import kotlin.coroutines.resume

suspend fun <T : Any> Deferred<ApiResponse<T>>.awaitResult(): CallResult<T> =
    suspendCancellableCoroutine { continuation ->

        GlobalScope.launch {
            try {
                val response = await()
                continuation.resume(CallResult.Success(response.message))
            } catch (e: Throwable) {
                continuation.resume(CallResult.Error(e))
            }
        }
        registerOnCompletion(continuation)
    }

private fun Deferred<*>.registerOnCompletion(continuation: CancellableContinuation<*>) {
    continuation.invokeOnCancellation {
        if (continuation.isCancelled)
            try {
                cancel()
            } catch (ex: Throwable) {
                //Ignore cancel exception
                ex.printStackTrace()
            }
    }
}
