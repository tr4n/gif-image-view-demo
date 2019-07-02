package com.example.demoproject3.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    fun <T> buildRestApi(
        baseUrl: String,
        restApi: Class<T>,
        converterFactory: GsonConverterFactory,
        callAdapterFactory: CoroutineCallAdapterFactory
    ): T =
        buildService(baseUrl, restApi, converterFactory, callAdapterFactory)

    private fun <T> buildService(
        baseUrl: String,
        restApi: Class<T>,
        converterFactory: GsonConverterFactory,
        callAdapterFactory: CoroutineCallAdapterFactory
    ): T =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
            .create(restApi)
}
