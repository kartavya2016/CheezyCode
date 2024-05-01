package com.ksofttech.cheezycodedemo.quotes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class QuotesViewModel(private val context: Context) : ViewModel() {

    private var quoteList: Array<Quotes> = emptyArray()
    private var index: Int = 0

    init {
        quoteList = loadFromAssets()
    }

    fun loadFromAssets(): Array<Quotes> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quotes>::class.java)
    }

    fun getQuotes(): Quotes {
        return quoteList[index]
    }

    fun getNextQuotes() {
        quoteList[index++]
    }

    fun getPreviousQuotes() {
        if (index != 0) {
            quoteList[index--]
        } else {
            getQuotes()
        }
    }
}