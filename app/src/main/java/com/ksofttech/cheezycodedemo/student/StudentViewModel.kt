package com.ksofttech.cheezycodedemo.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(val studentRepository: StudentRepository) : ViewModel() {

    fun addStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.addStudent(student)
        }
    }

    fun getAllStudent(): LiveData<List<Student>> {
        return studentRepository.getAllStudent()
    }
}