package com.example.demoproject3.data.source.local

import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.coroutine.DataNotAvailableException
import com.example.demoproject3.data.source.BreedsDataSource
import com.example.demoproject3.data.source.db.AppDatabase
import com.example.demoproject3.data.source.db.entity.Breed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedsLocalDataSource(private val appDatabase: AppDatabase) : BreedsDataSource.Local {

    override suspend fun getLocalBreeds(): CallResult<List<Breed>> = withContext(Dispatchers.IO) {
        val resultData = appDatabase.breedDao().getBreeds()
        resultData?.let{
            CallResult.Success(it)
        }?: CallResult.Error(DataNotAvailableException())
    }
}
