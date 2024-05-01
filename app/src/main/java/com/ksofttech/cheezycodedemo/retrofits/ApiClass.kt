package com.ksofttech.cheezycodedemo.retrofits

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClass {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

}