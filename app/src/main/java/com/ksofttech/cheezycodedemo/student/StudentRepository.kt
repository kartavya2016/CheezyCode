package com.ksofttech.cheezycodedemo.student

import androidx.lifecycle.LiveData

class StudentRepository(val studentDAO: StudentDAO) {

    fun addStudent(student: Student) {
        studentDAO.addStudent(student)
    }

    fun getAllStudent(): LiveData<List<Student>> {
        return studentDAO.getAllStudent()
    }
}