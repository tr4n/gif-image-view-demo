package com.example.demoproject3.data.source

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.api.response.DogCeoResponse
import com.example.demoproject3.data.api.response.TheDogApiResponse
import com.example.demoproject3.data.source.db.entity.Breed

interface BreedsDataSource {

    interface Remote {
        suspend fun getBreeds(): CallResult<List<TheDogApiResponse>>
        suspend fun getImages(breedName: String): CallResult<DogCeoResponse<List<String>>>
    }

    interface Local {
        suspend fun getLocalBreeds(): CallResult<List<Breed>>
    }
}