package com.ksofttech.cheezycodedemo.postoffice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(val postRepository: PostRepository) : ViewModel() {

    val postLiveData: LiveData<PostResult>
        get() = postRepository.postLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPostData()
        }
    }

}