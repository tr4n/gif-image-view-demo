package com.example.demoproject3.di

import com.example.demoproject3.data.api.DogCeoApi
import com.example.demoproject3.data.source.db.AppDatabase
import com.example.demoproject3.utils.KoinNames
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{

    single(named(KoinNames.APP_DATABASE)) {
        AppDatabase.getInstance(context = androidContext())
    }

    single(named(KoinNames.DOG_CEO_API)) {
        DogCeoApi.getService(
            baseUrl = get(named(KoinNames.DOG_CEO_BASE_URL)),
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
}
