package com.dmabram15.moviesapp

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

const val IMAGE_URI_PREFIX = "https://image.tmdb.org/t/p/w500/"

@Suppress("IMPLICIT_CAST_TO_ANY")
fun ImageView.setImageFromUri(uri: String, placeholder: Int = 0) {

    val glideUrl = if (uri.isEmpty()) placeholder else GlideUrl("$IMAGE_URI_PREFIX$uri")

    Glide.with(context)
        .load(glideUrl)
        .placeholder(placeholder)
        .into(this)
}

fun View.click(click: () -> Unit) = setOnClickListener { click() }