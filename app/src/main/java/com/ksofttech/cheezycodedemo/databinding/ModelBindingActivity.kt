package com.ksofttech.cheezycodedemo.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ksofttech.cheezycodedemo.LiveModel
import com.ksofttech.cheezycodedemo.R

class ModelBindingActivity : AppCompatActivity() {

    lateinit var liveModel: LiveModel
    lateinit var binding: ActivityModelBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_model_binding)

        liveModel = ViewModelProvider(this)[LiveModel::class.java]
        binding.livedata = liveModel
        binding.lifecycleOwner = this
    }
}