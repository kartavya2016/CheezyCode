package com.ksofttech.cheezycodedemo.postoffice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class PostAdapter(val postArray: List<PostOffice>,val postInterface: PostInterface) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.row_postoffice,parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postArray.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val postOffice = postArray[position]
        holder.tvCName.text = postOffice.Name

        holder.itemView.setOnClickListener {
            postInterface.getPostDetail(postOffice)
        }
    }


    class PostHolder(itemtView: View) : RecyclerView.ViewHolder(itemtView) {
        val tvCName = itemtView.findViewById<TextView>(R.id.tvCName)
    }

}