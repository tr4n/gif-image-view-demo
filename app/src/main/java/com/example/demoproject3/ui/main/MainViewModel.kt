package com.example.demoproject3.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.demoproject3.R
import com.example.demoproject3.ui.base.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainViewModel"

class MainViewModel : BaseViewModel() {

    val itemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        navigationItemSelectedId.value = it.itemId
        true
    }

    val navigationItemSelectedId: MutableLiveData<Int> = MutableLiveData<Int>().apply {
        value = R.id.item_search
    }

    override fun create() {

    }

    companion object {
        const val NAME = "MainViewModel"
    }
}
