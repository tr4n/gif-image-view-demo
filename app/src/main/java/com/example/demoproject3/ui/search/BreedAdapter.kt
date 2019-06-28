package com.example.demoproject3.ui.search

import android.view.ViewGroup
import com.example.demoproject3.R
import com.example.demoproject3.data.source.db.entity.Breed
import com.example.demoproject3.databinding.ItemBreedBinding
import com.example.demoproject3.ui.base.BaseRecyclerAdapter

class BreedAdapter : BaseRecyclerAdapter<Breed, ItemBreedBinding, BreedAdapter.BreedViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_breed

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder = BreedViewHolder(
        getViewHolderDataBinding(parent, viewType) as ItemBreedBinding
    )

    class BreedViewHolder(
        binding: ItemBreedBinding
    ) : BaseRecyclerAdapter.BaseViewHolder<Breed, ItemBreedBinding>(binding) {

        override fun onBindData(itemData: Breed) {
            binding.itemBreed = itemData
        }
    }
}
