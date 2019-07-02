package com.example.demoproject3.di

import com.example.demoproject3.data.api.ApiFactory
import com.example.demoproject3.data.api.DogCeoApi
import com.example.demoproject3.data.api.TheDogApi
import com.example.demoproject3.data.source.db.AppDatabase
import com.example.demoproject3.utils.KoinNames
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single(named(KoinNames.APP_DATABASE)) {
        AppDatabase.getInstance(context = androidContext())
    }

    single(named(KoinNames.DOG_CEO_API)) {
        ApiFactory.buildRestApi(
            baseUrl = get(named(KoinNames.DOG_CEO_BASE_URL)),
            restApi = DogCeoApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.THE_DOG_API)) {
        ApiFactory.buildRestApi(
            baseUrl = get(named(KoinNames.THE_DOG_API_BASE_URL)),
            restApi = TheDogApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY)) {
        CoroutineCallAdapterFactory()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }

    single(named(KoinNames.DOG_CEO_BASE_URL)) {
        DogCeoApi.BASE_URL
    }

    single(named(KoinNames.THE_DOG_API_BASE_URL)) {
        TheDogApi.BASE_URL
    }
}
