package com.example.demoproject3.di

import com.example.demoproject3.data.repository.BreedsLocalRepository
import com.example.demoproject3.data.repository.BreedsRemoteRepository
import com.example.demoproject3.data.source.local.BreedsLocalDataSource
import com.example.demoproject3.data.source.remote.BreedsRemoteDataSource
import com.example.demoproject3.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.BREEDS_LOCAL_DATA_SOURCE)) {
        BreedsLocalDataSource(appDatabase = get(named(KoinNames.APP_DATABASE)))
    }

    single(named(KoinNames.BREEDS_REMOTE_DATA_SOURCE)) {
        BreedsRemoteDataSource(dogCeoApi = get(named(KoinNames.DOG_CEO_API)))
    }

    single(named(KoinNames.BREEDS_LOCAL_REPOSITORY)) {
        BreedsLocalRepository(localDataSource = get(named(KoinNames.BREEDS_LOCAL_DATA_SOURCE)))
    }

    single(named(KoinNames.BREEDS_REMOTE_REPOSITORY)) {
        BreedsRemoteRepository(remoteDataSource = get(named(KoinNames.BREEDS_REMOTE_DATA_SOURCE)))
    }
}
