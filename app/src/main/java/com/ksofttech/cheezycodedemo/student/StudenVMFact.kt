package com.ksofttech.cheezycodedemo.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudenVMFact(val studentRepository: StudentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StudentViewModel(studentRepository) as T
    }
}