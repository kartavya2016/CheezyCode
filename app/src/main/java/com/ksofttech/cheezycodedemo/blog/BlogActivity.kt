package com.ksofttech.cheezycodedemo.blog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class BlogActivity : AppCompatActivity(), RemoveBlogs {

    lateinit var edtTitle: EditText
    lateinit var edtAuthor: EditText
    lateinit var btnAdd: Button
    lateinit var rvData: RecyclerView
    lateinit var linearLayoutManager:LinearLayoutManager

    lateinit var blogViewModel: BlogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        blogViewModel=ViewModelProvider(this)[BlogViewModel::class.java]

        initUI()

        blogViewModel.blogLiveData.observe(this){blogArray->
            rvData.adapter=BlogAdapter(blogArray,this)
        }
    }

    private fun initUI() {
        edtTitle = findViewById(R.id.edtTitle)
        edtAuthor = findViewById(R.id.edtAuthor)
        btnAdd = findViewById(R.id.btnAdd)

        rvData = findViewById(R.id.rvData)
        linearLayoutManager= LinearLayoutManager(this)
        rvData.layoutManager=linearLayoutManager
        rvData.itemAnimator=DefaultItemAnimator()
        rvData.setHasFixedSize(true)


        btnAdd.setOnClickListener {
            if(edtTitle.text.toString().isEmpty())
            {
                Toast.makeText(applicationContext,"Enter Title",Toast.LENGTH_SHORT).show()
            }else if(edtAuthor.text.toString().isEmpty())
            {
                Toast.makeText(applicationContext,"Enter Author",Toast.LENGTH_SHORT).show()
            }else
            {
                var title = edtTitle.text.toString().trim()
                var author = edtAuthor.text.toString().trim()
                val blogs = Blogs(title,author)
                blogViewModel.addBlog(blogs)
                rvData.adapter?.notifyDataSetChanged()
                Toast.makeText(applicationContext,"Added...",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun deleteBlogs(blogs: Blogs) {
        val alertDialog = AlertDialog.Builder(this@BlogActivity)
        alertDialog.apply {
            setTitle("Remove!!")
            setMessage("Are you sure you want to Remove?")
            setPositiveButton("Ok",DialogInterface.OnClickListener { dialogInterface, i ->  blogViewModel.removeBlogs(blogs) })
            setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->  dialogInterface.dismiss() })
        }
        alertDialog.create()
        alertDialog.show()
    }
}