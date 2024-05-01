package com.ksofttech.cheezycodedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ksofttech.cheezycodedemo.bindingadapters.PostBIActivity
import com.ksofttech.cheezycodedemo.blog.BlogActivity
import com.ksofttech.cheezycodedemo.databinding.BindingActivity
import com.ksofttech.cheezycodedemo.databinding.ModelBindingActivity
import com.ksofttech.cheezycodedemo.databse.ContactDBActivity
import com.ksofttech.cheezycodedemo.diffutils.DiffActivity
import com.ksofttech.cheezycodedemo.postoffice.PostActivity
import com.ksofttech.cheezycodedemo.quotes.QuotesVActivity
import com.ksofttech.cheezycodedemo.retrofits.RetrofitDemoActivity
import com.ksofttech.cheezycodedemo.student.StudentActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, StudentActivity::class.java))
        }, 500)
    }
}