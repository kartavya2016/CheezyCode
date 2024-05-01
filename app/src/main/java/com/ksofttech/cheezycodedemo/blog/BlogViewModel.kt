package com.ksofttech.cheezycodedemo.blog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {

    var blogList = arrayListOf<Blogs>()
    var blogLiveData = MutableLiveData<ArrayList<Blogs>>()

    fun addBlog(blogs: Blogs) {
        blogList.add(blogs)
        blogLiveData.value = blogList
    }

    fun removeBlogs(blogs: Blogs) {
        blogList.remove(blogs)
        blogLiveData.value = blogList
    }
}