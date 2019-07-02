package com.example.demoproject3.ui.search

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoproject3.coroutine.CallResult
import com.example.demoproject3.data.repository.BreedsLocalRepository
import com.example.demoproject3.data.source.db.entity.Breed
import com.example.demoproject3.ui.base.BaseViewModel
import kotlinx.coroutines.launch

private const val TAG = "SearchViewModel"

class SearchViewModel(
    private val lifecycleOwner: LifecycleOwner,
    private val repository: BreedsLocalRepository
) : BaseViewModel() {

    val breedAdapter = BreedAdapter()
    val searchBoxVisible: Boolean = false

    private val localBreeds = MutableLiveData<List<Breed>>().apply {
        value = emptyList()
        observe(lifecycleOwner, Observer { breeds ->
            breeds?.let {
                breedAdapter.updateData(it)
            }
        })
    }

    override fun create() {
        getBreeds()
    }

    private fun getBreeds() = launch {
        val result = repository.getLocalBreeds()
        localBreeds.value = if (result is CallResult.Success) result.data else emptyList()
    }
}