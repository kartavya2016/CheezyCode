package com.ksofttech.cheezycodedemo.student

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblStudent")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rollNo: Int,
    val name: String,
    val address: String,
    val city: String
)
