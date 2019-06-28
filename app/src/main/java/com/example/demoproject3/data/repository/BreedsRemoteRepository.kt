package com.example.demoproject3.data.repository

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.source.BreedsDataSource

class BreedsRemoteRepository(
    private val remoteDataSource: BreedsDataSource.Remote
) : BreedsDataSource.Remote {

    override suspend fun getBreeds(): CallResult<List<String>> = remoteDataSource.getBreeds()

    override suspend fun getImages(breedName: String): CallResult<List<String>> = remoteDataSource.getImages(breedName)
}
