package com.ksofttech.cheezycodedemo.diffutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class DiffActivity : AppCompatActivity() {

    lateinit var rvData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)

        rvData = findViewById(R.id.rvData)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingData(1, "J", "Java")
        val p2 = ProgrammingData(2, "C++", "C++")
        val p3 = ProgrammingData(3, "C", "C")

        adapter.submitList(listOf(p1, p2, p3))
        val linearLayoutManager = LinearLayoutManager(this)
        rvData.layoutManager = linearLayoutManager
        rvData.setHasFixedSize(true)
        rvData.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({

            val p3 = ProgrammingData(3, "J", "Java")
            val p4 = ProgrammingData(4, "P++", "C++")
            val p5 = ProgrammingData(5, "Q", "C")
            adapter.submitList(listOf(p3, p4, p5))
        }, 4000)
    }
}