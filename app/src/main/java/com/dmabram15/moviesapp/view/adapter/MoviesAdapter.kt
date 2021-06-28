package com.dmabram15.moviesapp.view.adapter

import android.view.ViewGroup
import android.view.LayoutInflater.from
import androidx.recyclerview.widget.ListAdapter
import com.dmabram15.moviesapp.databinding.ItemMovieBinding
import com.dmabram15.moviesapp.model.Movie

class MoviesAdapter : ListAdapter<Movie, MoviesViewHolder>(MovieDiffUtils) {

    private val payload = Any()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            ItemMovieBinding.inflate(from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}