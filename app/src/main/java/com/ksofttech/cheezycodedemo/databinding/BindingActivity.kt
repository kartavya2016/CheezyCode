package com.ksofttech.cheezycodedemo.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ksofttech.cheezycodedemo.R
import com.ksofttech.cheezycodedemo.blog.Blogs

class BindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding)

        val blogs = Blogs("This is Test Email", "Data Binding data")
        binding.blogs = blogs

    }
}