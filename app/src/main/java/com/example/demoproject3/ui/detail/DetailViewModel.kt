package com.example.demoproject3.ui.detail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.repository.BreedsRemoteRepository
import com.example.demoproject3.ui.base.BaseViewModel
import kotlinx.coroutines.launch

private const val TAG = "DetailViewModel"

class DetailViewModel(
    private val lifecycleOwner: LifecycleOwner,
    private val repository: BreedsRemoteRepository
) : BaseViewModel() {

    val breedImageAdapter = BreedImageAdapter()

    private val imageUrls = MutableLiveData<List<String>>().apply {
        value = emptyList()
        observe(lifecycleOwner, Observer { imageUrls ->
            imageUrls?.let {
                breedImageAdapter.updateData(it)
            }
        })
    }

    override fun create() {
        getBreedImageUrls(breedName = "newfoundland")
    }

    private fun getBreedImageUrls(breedName: String) = launch {
        val result = repository.getImages(breedName)
        imageUrls.value = if (result is CallResult.Success) result.data.message else emptyList()
    }
}
