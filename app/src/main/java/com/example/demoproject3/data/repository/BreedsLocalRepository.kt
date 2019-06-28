package com.example.demoproject3.data.repository

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.source.BreedsDataSource
import com.example.demoproject3.data.source.db.entity.Breed

class BreedsLocalRepository(
    private val localDataSource: BreedsDataSource.Local
) : BreedsDataSource.Local {

    override suspend fun getLocalBreeds(): CallResult<List<Breed>> = localDataSource.getLocalBreeds()
}
