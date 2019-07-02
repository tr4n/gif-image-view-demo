package com.example.demoproject3.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.resume

suspend fun <T : Any> Deferred<T>.awaitResult(): CallResult<T> =
    suspendCancellableCoroutine { continuation ->

        GlobalScope.launch {
            try {
                val response = await()
                if (response.isNotAvailable()) {
                    throw DataNotAvailableException()
                } else {
                    continuation.resume(CallResult.Success(response))
                }
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

private fun <RESPONSE> RESPONSE.isNotAvailable(): Boolean = this == null || (this is List<*> && isEmpty())

