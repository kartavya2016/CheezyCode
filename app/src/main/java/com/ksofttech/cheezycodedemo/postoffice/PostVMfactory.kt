package com.ksofttech.cheezycodedemo.postoffice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PostVMfactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}