package com.ksofttech.cheezycodedemo

import androidx.lifecycle.ViewModel

class CountViewModel(counter: Int) : ViewModel() {

    var count: Int = counter

    fun increment() {
        count++
    }

    fun decrement() {
        if (count != 0) {
            count--
        }
    }
}