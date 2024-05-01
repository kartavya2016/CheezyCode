package com.ksofttech.cheezycodedemo.student

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDAO(): StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getSDatabase(context: Context): StudentDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context, StudentDatabase::class.java, "studentDatabase"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}