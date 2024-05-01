package com.ksofttech.cheezycodedemo.bindingadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ksofttech.cheezycodedemo.R
import com.ksofttech.cheezycodedemo.databinding.ActivityPostBiactivityBinding

class PostBIActivity : AppCompatActivity() {

    lateinit var binding: ActivityPostBiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_biactivity)


        val post = Post(
            "Introduction",
            "Cheezy Code",
            "https://i.pinimg.com/originals/13/11/a9/1311a95fa6830b852fbda8113cb3d7e5.jpg"
        )
        binding.post = post
    }
}