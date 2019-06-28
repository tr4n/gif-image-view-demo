package com.example.demoproject3.di

import androidx.lifecycle.LifecycleOwner
import com.example.demoproject3.ui.main.MainViewModel
import com.example.demoproject3.ui.search.SearchViewModel
import com.example.demoproject3.utils.KoinNames
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    viewModel(named<MainViewModel>()) { (lifecycleOwner: LifecycleOwner) ->
        MainViewModel(lifecycleOwner)
    }

    viewModel(named<SearchViewModel>()) { (lifecycleOwner: LifecycleOwner) ->
        SearchViewModel(lifecycleOwner = lifecycleOwner, repository = get(named(KoinNames.BREEDS_LOCAL_REPOSITORY)))
    }
}
