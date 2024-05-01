package com.ksofttech.cheezycodedemo.postoffice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ksofttech.cheezycodedemo.R
import com.ksofttech.cheezycodedemo.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity(), PostInterface {

    lateinit var binding: ActivityPostBinding

    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        val postApiInterface = PostHelper.getInstance().create(PostApiInterface::class.java)
        val postRepository = PostRepository(postApiInterface)
        postViewModel =
            ViewModelProvider(this, PostVMfactory(postRepository))[PostViewModel::class.java]

        binding.rvPostOffice.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvPostOffice.layoutManager = linearLayoutManager

        postViewModel.postLiveData.observe(this) {
            binding.rvPostOffice.adapter = PostAdapter(it.PostOffice, this)
            binding.progressbar.visibility = View.GONE
        }

    }

    override fun getPostDetail(postOffice: PostOffice) {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.post_bottomsheet)
        val tvCName = bottomSheetDialog.findViewById<TextView>(R.id.tvCName)
        val tvPincode = bottomSheetDialog.findViewById<TextView>(R.id.tvPincode)
        val tvTaluka = bottomSheetDialog.findViewById<TextView>(R.id.tvTaluka)
        postOffice.let {
            tvCName?.text = it.Name
            tvTaluka?.text = it.Taluk
            tvPincode?.text = it.PINCode
        }

        bottomSheetDialog.show()
    }
}