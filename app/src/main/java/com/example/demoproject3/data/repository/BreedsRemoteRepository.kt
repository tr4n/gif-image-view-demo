package com.example.demoproject3.data.repository

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.api.response.DogCeoResponse
import com.example.demoproject3.data.api.response.TheDogApiResponse
import com.example.demoproject3.data.source.BreedsDataSource

class BreedsRemoteRepository(
    private val remoteDataSource: BreedsDataSource.Remote
) : BreedsDataSource.Remote {

    override suspend fun getBreeds(): CallResult<List<TheDogApiResponse>> = remoteDataSource.getBreeds()

    override suspend fun getImages(breedName: String): CallResult<DogCeoResponse<List<String>>> =
        remoteDataSource.getImages(breedName)
}
