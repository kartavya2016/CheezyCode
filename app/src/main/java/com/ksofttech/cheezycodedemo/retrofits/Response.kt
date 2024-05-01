package com.ksofttech.cheezycodedemo.retrofits

sealed class Response {
    class Loading : Response()
    class Success(val quoteList: QuoteList) : Response()
    class Error(val errorMessage: String) : Response()
}


//Also use generics
sealed class Response2<T> {
    class Loading<T> : Response2<T>()
    class Success<T>(val quoteList: QuoteList) : Response2<T>()
    class Error<T>(val errorMessage: String) : Response2<T>()
}
