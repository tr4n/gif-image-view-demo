package com.example.demoproject3.ui.search

import android.view.View
import com.example.demoproject3.R
import com.example.demoproject3.databinding.FragmentSearchBinding
import com.example.demoproject3.ui.base.BaseFragment
import com.example.demoproject3.ui.base.OnClickHandler
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class SearchFragment : BaseFragment<FragmentSearchBinding>(), OnClickHandler {

    override val layoutResource = R.layout.fragment_search

    private val searchViewModel: SearchViewModel by viewModel(named<SearchViewModel>()) { parametersOf(this) }

    override fun initComponents() {
        searchViewModel.create()
        viewDataBinding.apply {
            searchViewModelBinding = searchViewModel
            eventHandler = this@SearchFragment
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.imageSearch -> constraintSearchBox?.visibility = View.VISIBLE
            R.id.imageCancel -> constraintSearchBox?.visibility = View.GONE
        }
    }
}
