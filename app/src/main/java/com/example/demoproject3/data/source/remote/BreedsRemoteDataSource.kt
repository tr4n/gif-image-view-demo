package com.example.demoproject3.data.source.remote

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.coroutine.awaitResult
import com.example.demoproject3.data.api.DogCeoApi
import com.example.demoproject3.data.source.BreedsDataSource
import javax.inject.Inject
import javax.inject.Named

class BreedsRemoteDataSource(private val dogCeoApi: DogCeoApi) : BreedsDataSource.Remote {

    override suspend fun getBreeds(): CallResult<List<String>> = dogCeoApi.getBreedsAsync().awaitResult()

    override suspend fun getImages(breedName: String): CallResult<List<String>> =
        dogCeoApi.getImagesAsync(breedName).awaitResult()
}
