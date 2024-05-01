package com.ksofttech.cheezycodedemo.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class StudentAdapter(val studenList: ArrayList<Student>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.row_student,parent,false)
        return StudentHolder(rowView)
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val student:Student = studenList[position]
        holder.bind(student)
    }


    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRollNo = itemView.findViewById<TextView>(R.id.tvRollNo)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvCity = itemView.findViewById<TextView>(R.id.tvCity)

        fun bind(item:Student)
        {
            tvName.text=item.name
            tvAddress.text=item.address
            tvRollNo.text=item.rollNo.toString()
            tvCity.text=item.city
        }
    }
}