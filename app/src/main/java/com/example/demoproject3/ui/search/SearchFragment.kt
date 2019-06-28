package com.example.demoproject3.ui.search

import com.example.demoproject3.R
import com.example.demoproject3.databinding.FragmentSearchBinding
import com.example.demoproject3.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutResource = R.layout.fragment_search

    private val searchViewModel: SearchViewModel by viewModel(named<SearchViewModel>()) { parametersOf(this) }

    override fun initComponents() {
        searchViewModel.onCreate()
        viewDataBinding.searchViewModelBinding = searchViewModel
    }
}
