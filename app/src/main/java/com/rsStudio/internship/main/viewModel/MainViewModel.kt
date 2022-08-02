package com.rsStudio.internship.main.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsStudio.internship.retrofit.BeerInfoRepository
import com.rsStudio.internship.retrofit.networkEntity.BeerNetworkEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: BeerInfoRepository
): ViewModel() {

    private val logTag = "@MainViewModel"

    private val _response = MutableLiveData<List<BeerNetworkEntity>>()

    val responseBeerDetail: LiveData<List<BeerNetworkEntity>>
        get() = _response

    init {
        getAllUsers()
    }

    private fun getAllUsers() = viewModelScope.launch {

        repository.getBeerInfo().let { response ->

            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d(logTag, "error: ${response.errorBody()} ")
            }

        }
    }

}