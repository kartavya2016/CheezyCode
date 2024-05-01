package com.ksofttech.cheezycodedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class CountActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvCount: TextView
    lateinit var btnInc: Button
    lateinit var btnDec: Button

    lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        countViewModel = ViewModelProvider(this,CounterFactory(10)).get(CountViewModel::class.java)

        initUI()
        listener()

        setText()
    }

    private fun initUI() {
        tvCount = findViewById(R.id.tvCount)
        btnInc = findViewById(R.id.btnInc)
        btnDec = findViewById(R.id.btnDenc)
    }

    private fun listener() {
        btnInc.setOnClickListener(this)
        btnDec.setOnClickListener(this)
    }

    fun setText() {
        tvCount.text = countViewModel.count.toString()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnInc -> {
                countViewModel.increment()
                setText()
            }

            R.id.btnDenc -> {
                countViewModel.decrement()
                setText()
            }

            else -> {

            }
        }
    }
}