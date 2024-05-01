package com.ksofttech.cheezycodedemo.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ksofttech.cheezycodedemo.R
import com.ksofttech.cheezycodedemo.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    lateinit var binding: ActivityStudentBinding

    lateinit var studentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student)

        val studentDAO = StudentDatabase.getSDatabase(applicationContext).studentDAO()
        val studentRepository = StudentRepository(studentDAO)
        studentViewModel =
            ViewModelProvider(this, StudenVMFact(studentRepository))[StudentViewModel::class.java]

        binding.btnSave.setOnClickListener {
            checkValidation()
        }

        binding.btnShowRecord.setOnClickListener {
            val intent = Intent(this, ShowStudentActivity::class.java)
            startActivity(intent)
        }

    }

    private fun checkValidation() {
        if (binding.edtRollNo.text.isEmpty()) {
            StudentUtils.createMessage(applicationContext, "RollNo")
        } else if (binding.edtName.text.isEmpty()) {
            StudentUtils.createMessage(applicationContext, "Name")
        } else if (binding.edtAddress.text.isEmpty()) {
            StudentUtils.createMessage(applicationContext, "Address")
        } else if (binding.edtCity.text.isEmpty()) {
            StudentUtils.createMessage(applicationContext, "City")
        } else {
            var rollNo = binding.edtRollNo.text.toString().toInt()
            var name = binding.edtName.text.toString()
            var address = binding.edtAddress.text.toString()
            var city = binding.edtCity.text.toString()

            val student = Student(0, rollNo, name, address, city)
            studentViewModel.addStudent(student)
            StudentUtils.createMessage(applicationContext, "Student Information Addedd..")
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.edtCity.windowToken, 0)
            clearData()
        }
    }

    fun clearData() {
        binding.edtRollNo.setText("")
        binding.edtName.setText("")
        binding.edtAddress.setText("")
        binding.edtCity.setText("")
        binding.edtRollNo.requestFocus()
    }
}