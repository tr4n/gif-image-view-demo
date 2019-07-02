package com.example.demoproject3.ui.detail

import com.example.demoproject3.R
import com.example.demoproject3.databinding.FragmentDetailBinding
import com.example.demoproject3.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val layoutResource = R.layout.fragment_detail
    private val detailViewModel: DetailViewModel by viewModel(named<DetailViewModel>()) { parametersOf(this) }

    override fun initComponents() {
        detailViewModel.create()
        viewDataBinding.detailViewModelBinding = detailViewModel
    }
}
