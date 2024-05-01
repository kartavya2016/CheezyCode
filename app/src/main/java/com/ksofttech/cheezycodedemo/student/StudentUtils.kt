package com.ksofttech.cheezycodedemo.student

import android.content.Context
import android.widget.Toast

class StudentUtils {

    companion object {

        fun createMessage(context: Context, str: String) {
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
        }
    }
}