package com.ksofttech.cheezycodedemo.databse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblContact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: String,
    val isActive: Int
)
