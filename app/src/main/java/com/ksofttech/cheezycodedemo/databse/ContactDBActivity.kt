package com.ksofttech.cheezycodedemo.databse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ksofttech.cheezycodedemo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ContactDBActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_dbactivity)

        database = ContactDatabase.getDatabase(this)

//        GlobalScope.launch {
//            database.contactDao().insert(Contact(0, "Chirag", "7383085340"))
//            //Toast.makeText(applicationContext, "Added...", Toast.LENGTH_SHORT).show()
//        }

        database.contactDao().getAll().observe(this) { contactList ->

            for (item in contactList) {
                Toast.makeText(
                    applicationContext,
                    item.id.toString() + "" + item.name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}