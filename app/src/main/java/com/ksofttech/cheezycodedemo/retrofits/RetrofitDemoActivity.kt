package com.ksofttech.cheezycodedemo.retrofits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ksofttech.cheezycodedemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_demo)

        val quotesAPI = RetrofitHelper.getInstance().create(ApiClass::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val result = quotesAPI.getQuotes(1)
            result.let {
                val list = it.body()?.results
                list?.forEach {
                    Log.e("Response=>", it.content)
                }
            }
        }
    }
}