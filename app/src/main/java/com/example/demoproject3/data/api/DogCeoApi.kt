package com.example.demoproject3.data.api

import com.example.demoproject3.data.api.response.DogCeoResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

private const val ENDPOINT_BREEDS = "api/breeds/list"
private const val ENDPOINT_IMAGES = "api/breed/{breedName}/images"

@Singleton
interface DogCeoApi {

    @GET(ENDPOINT_BREEDS)
    fun getBreedsAsync(): Deferred<DogCeoResponse<List<String>>>

    @GET(ENDPOINT_IMAGES)
    fun getImagesAsync(@Path("breedName") breedName: String): Deferred<DogCeoResponse<List<String>>>

    companion object {
        const val NAME = "DogCeoApi"
        const val BASE_URL = "https://dog.ceo"
    }
}
