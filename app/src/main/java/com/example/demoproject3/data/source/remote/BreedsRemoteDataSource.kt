package com.example.demoproject3.data.source.remote

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.coroutine.awaitResult
import com.example.demoproject3.data.api.DogCeoApi
import com.example.demoproject3.data.api.TheDogApi
import com.example.demoproject3.data.api.response.DogCeoResponse
import com.example.demoproject3.data.api.response.TheDogApiResponse
import com.example.demoproject3.data.source.BreedsDataSource

class BreedsRemoteDataSource(
    private val dogCeoApi: DogCeoApi,
    private val theDogApi: TheDogApi
) : BreedsDataSource.Remote {

    override suspend fun getBreeds(): CallResult<List<TheDogApiResponse>> = theDogApi.getBreedsAsync().awaitResult()

    override suspend fun getImages(breedName: String): CallResult<DogCeoResponse<List<String>>> =
        dogCeoApi.getImagesAsync(breedName).awaitResult()
}
