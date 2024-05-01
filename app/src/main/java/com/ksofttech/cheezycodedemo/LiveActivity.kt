package com.ksofttech.cheezycodedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class LiveActivity : AppCompatActivity() {

    private val tvFacts: TextView
        get() = findViewById(R.id.tvFacts)
    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)

    lateinit var liveModel: LiveModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live)

        liveModel = ViewModelProvider(this)[LiveModel::class.java]

        liveModel.factsLiveData.observe(this) {
            tvFacts.text = it.toString()
        }

        btnUpdate.setOnClickListener {
            liveModel.updateLiveData()
        }
    }
}