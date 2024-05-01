package com.ksofttech.cheezycodedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveModel : ViewModel() {

    private val factLiveDataObj = MutableLiveData<String>("This is fact live data")

    val factsLiveData: LiveData<String>
        get() = factLiveDataObj

    fun updateLiveData() {
        factLiveDataObj.value = "This is updated"
    }
}