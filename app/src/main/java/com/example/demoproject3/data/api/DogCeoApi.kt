package com.example.demoproject3.data.api

import com.example.demoproject3.data.api.response.ApiResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

private const val ENDPOINT_BREEDS = "api/breeds/list"
private const val ENDPOINT_IMAGES = "api/breed/{breedName}/images"

@Singleton
interface DogCeoApi {

    @GET(ENDPOINT_BREEDS)
    fun getBreedsAsync(): Deferred<ApiResponse<List<String>>>

    @GET(ENDPOINT_IMAGES)
    fun getImagesAsync(@Path("breedName") breedName: String): Deferred<ApiResponse<List<String>>>

    companion object {

        const val NAME = "DogCeoApi"
        const val BASE_URL = "https://dog.ceo"

        fun getService(
            baseUrl: String,
            converterFactory: GsonConverterFactory,
            callAdapterFactory: CoroutineCallAdapterFactory
        ): DogCeoApi =

            Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
                .create(DogCeoApi::class.java)
    }
}