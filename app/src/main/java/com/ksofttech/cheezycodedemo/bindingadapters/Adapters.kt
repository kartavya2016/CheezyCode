package com.ksofttech.cheezycodedemo.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.imegeFromUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}


