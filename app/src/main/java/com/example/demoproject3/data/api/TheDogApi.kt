package com.example.demoproject3.data.api

import com.example.demoproject3.data.api.response.TheDogApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

private const val ENDPOINT_BREEDS_SEARCH = "v1/breeds/search"
private const val ENDPOINT_BREEDS = "v1/breeds"
private const val HEADERS_X_API_KEY = "x-api-key: 5e1b182d-5218-49d9-bbe0-780bdd3befa9"

private const val QUERY_Q = "q"

@Singleton
interface TheDogApi {

    @Headers(HEADERS_X_API_KEY)
    @GET(ENDPOINT_BREEDS)
    fun getBreedsAsync(): Deferred<List<TheDogApiResponse>>

    @Headers(HEADERS_X_API_KEY)
    @GET(ENDPOINT_BREEDS_SEARCH)
    fun getBreedByNameAsync(@Query(QUERY_Q) q: String): Deferred<List<TheDogApiResponse>>

    companion object {
        const val NAME = "TheDogApi"
        const val BASE_URL = "https://api.thedogapi.com"
    }
}