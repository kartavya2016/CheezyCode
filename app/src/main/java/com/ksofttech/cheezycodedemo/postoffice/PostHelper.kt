package com.ksofttech.cheezycodedemo.postoffice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostHelper {

    private val BASE_URL = "http://www.postalpincode.in/api/postoffice/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}