package com.ksofttech.cheezycodedemo.postoffice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(private val postApiInterface: PostApiInterface) {

    val postMutableLiveData = MutableLiveData<PostResult>()
    val postLiveData: LiveData<PostResult>
        get() = postMutableLiveData

    fun getPostData() {
        val result = postApiInterface.getPostOfficeData()
        result.enqueue(object : Callback<PostResult> {
            override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        postMutableLiveData.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<PostResult>, t: Throwable) {
                Log.e("Response=>", t.message.toString())
            }
        })
    }
}