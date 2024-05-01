package com.ksofttech.cheezycodedemo.retrofits

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(val context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        //Call Repository
        CoroutineScope(Dispatchers.IO).launch {
            //call API from Repository
        }
        return Result.success()
    }
}