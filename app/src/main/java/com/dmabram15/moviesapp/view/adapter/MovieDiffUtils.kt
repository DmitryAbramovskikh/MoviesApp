package com.dmabram15.moviesapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dmabram15.moviesapp.model.Movie

object MovieDiffUtils : DiffUtil.ItemCallback<Movie>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Movie, newItem: Movie): Any? = payload
}