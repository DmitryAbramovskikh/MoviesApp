package com.dmabram15.moviesapp

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

@Suppress("IMPLICIT_CAST_TO_ANY")
fun ImageView.setImageFromUri(uri: String, placeholder: Int = 0) {
    val glideUrl = if (uri.isEmpty()) placeholder else GlideUrl(uri)

    Glide.with(context)
        .load(glideUrl)
        .placeholder(placeholder)
        .into(this)
}

fun View.click(click: () -> Unit) = setOnClickListener { click() }