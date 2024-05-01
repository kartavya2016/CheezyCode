package com.ksofttech.cheezycodedemo.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class BlogAdapter(val blogArray: ArrayList<Blogs>,val removeBlogs: RemoveBlogs) : RecyclerView.Adapter<BlogAdapter.BlogHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.row_blogs,parent,false)
        return BlogHolder(rowView)
    }

    override fun getItemCount(): Int {
        return blogArray.size
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        val blogs:Blogs = blogArray[position]
        holder.tvTitle.text = blogs.title
        holder.tvAuthor.text = blogs.author

        holder.itemView.setOnClickListener {
            removeBlogs.deleteBlogs(blogs)
        }
    }

    inner class BlogHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAuthor = view.findViewById(R.id.tvAuthor) as TextView
        val tvTitle = view.findViewById(R.id.tvTitle) as TextView
    }

}