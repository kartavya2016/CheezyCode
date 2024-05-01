package com.ksofttech.cheezycodedemo.student

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert
     fun addStudent(student: Student)

    @Query("select * from tblStudent")
    fun getAllStudent(): LiveData<List<Student>>
}