package com.ksofttech.cheezycodedemo.postoffice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiInterface {

    @GET("Vadodara")
     fun getPostOfficeData(): Call<PostResult>

}