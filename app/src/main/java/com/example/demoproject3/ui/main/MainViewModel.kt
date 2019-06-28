package com.example.demoproject3.ui.main

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoproject3.R
import com.example.demoproject3.ui.base.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(private val lifecycleOwner: LifecycleOwner) : BaseViewModel() {

    val itemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        navigationItemSelectedId.value = it.itemId
        true
    }

    val navigationItemSelectedId: MutableLiveData<Int> = MutableLiveData<Int>().apply{
        value = R.id.item_search
    }

    override fun onCreate() {

    }

    companion object {
        const val NAME = "MainViewModel"
    }
}
