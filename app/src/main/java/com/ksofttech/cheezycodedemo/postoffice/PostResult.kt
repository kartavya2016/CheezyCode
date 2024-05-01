package com.ksofttech.cheezycodedemo.postoffice

data class PostResult(
    val Message: String,
    val PostOffice: List<PostOffice>,
    val Status: String
)