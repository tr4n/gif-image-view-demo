package com.example.demoproject3.ui.main

import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

object MainBindingAdapters {

    @BindingAdapter("selectListener")
    @JvmStatic
    fun setNavigationItemSelectedListener(
        view: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener
    ) {
        view.setOnNavigationItemSelectedListener(listener)
    }
}
