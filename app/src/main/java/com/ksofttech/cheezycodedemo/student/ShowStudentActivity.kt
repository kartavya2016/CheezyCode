package com.ksofttech.cheezycodedemo.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class ShowStudentActivity : AppCompatActivity() {

    lateinit var rvStudent:RecyclerView

    lateinit var studentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_student)

        val studentDAO = StudentDatabase.getSDatabase(applicationContext).studentDAO()
        val studentRepository = StudentRepository(studentDAO)
        studentViewModel=ViewModelProvider(this,StudenVMFact(studentRepository))[StudentViewModel::class.java]

        rvStudent=findViewById(R.id.rvStudent)
        val linearLayoutManager = LinearLayoutManager(this)
        rvStudent.layoutManager=linearLayoutManager
        rvStudent.itemAnimator=DefaultItemAnimator()

       studentViewModel.getAllStudent().observe(this){
            rvStudent.adapter = StudentAdapter(it as ArrayList<Student>)
       }
    }
}