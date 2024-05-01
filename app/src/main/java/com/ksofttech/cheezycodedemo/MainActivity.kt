package com.ksofttech.cheezycodedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifecycleObserver())
        Log.e("Response=>", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Response=>", "onStart")
    }
}