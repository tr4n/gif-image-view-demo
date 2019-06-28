package com.example.demoproject3.data.source

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.source.db.entity.Breed

interface BreedsDataSource {

    interface Remote {
        suspend fun getBreeds(): CallResult<List<String>>
        suspend fun getImages(breedName: String): CallResult<List<String>>
    }

    interface Local {
        suspend fun getLocalBreeds(): CallResult<List<Breed>>
    }
}