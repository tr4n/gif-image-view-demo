package com.example.demoproject3.ui.detail

import android.view.ViewGroup
import com.example.demoproject3.R
import com.example.demoproject3.databinding.ItemBreedImageBinding
import com.example.demoproject3.ui.base.BaseRecyclerAdapter

class BreedImageAdapter : BaseRecyclerAdapter<String, ItemBreedImageBinding, BreedImageAdapter.BreedImageViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_breed_image

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedImageViewHolder = BreedImageViewHolder(
        getViewHolderDataBinding(parent, viewType) as ItemBreedImageBinding
    )

    class BreedImageViewHolder(
        binding: ItemBreedImageBinding
    ) : BaseRecyclerAdapter.BaseViewHolder<String, ItemBreedImageBinding>(binding) {

        override fun onBindData(itemData: String) {
            binding.breedImageUrl = itemData
        }
    }
}
