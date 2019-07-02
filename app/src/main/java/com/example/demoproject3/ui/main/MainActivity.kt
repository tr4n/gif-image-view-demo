package com.example.demoproject3.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.demoproject3.R
import com.example.demoproject3.databinding.ActivityMainBinding
import com.example.demoproject3.ui.detail.DetailFragment
import com.example.demoproject3.ui.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel(named<MainViewModel>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        mainViewModel.navigationItemSelectedId.observe(this, Observer {
            when (it) {
                R.id.item_search -> replaceFragment(R.id.frameMainContent, SearchFragment(), false)
                R.id.item_favorite -> replaceFragment(R.id.frameMainContent, DetailFragment(), false)
            }
        })

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            mainViewModelBinding = mainViewModel
        }
    }

    private fun replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        supportFragmentManager?.beginTransaction()?.replace(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    private fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        supportFragmentManager?.beginTransaction()?.add(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()
}
