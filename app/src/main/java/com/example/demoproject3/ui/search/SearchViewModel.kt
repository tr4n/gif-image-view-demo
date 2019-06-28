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

    private val localBreeds = MutableLiveData<List<Breed>>().apply {
        value = emptyList()
        observe(lifecycleOwner, Observer { breeds ->
            breeds?.let {
                breedAdapter.updateData(it)
            }
        })
    }

    override fun onCreate() {
        getBreeds()
    }

    private fun getBreeds() = launch {
        localBreeds.value = repository.getLocalBreeds().let { result ->

            if (result is CallResult.Success) result.data.also {
                Log.d(TAG, "$TAG result = $it " )
            } else emptyList()
        }
    }
}