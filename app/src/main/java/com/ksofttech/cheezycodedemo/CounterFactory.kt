package com.ksofttech.cheezycodedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterFactory(val counter:Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountViewModel(counter) as T
    }
}