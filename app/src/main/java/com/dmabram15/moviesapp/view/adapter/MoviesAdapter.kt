package com.dmabram15.moviesapp.view.adapter

import android.view.ViewGroup
import android.view.LayoutInflater.from
import androidx.recyclerview.widget.ListAdapter
import com.dmabram15.moviesapp.databinding.ItemMovieBinding
import com.dmabram15.moviesapp.model.Movie

class MoviesAdapter(private val delegate : Delegate) : ListAdapter<Movie, MoviesViewHolder>(MovieDiffUtils) {

    interface Delegate {
        fun onMoviePicked(movieId : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            ItemMovieBinding.inflate(from(parent.context), parent, false),
            delegate
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}