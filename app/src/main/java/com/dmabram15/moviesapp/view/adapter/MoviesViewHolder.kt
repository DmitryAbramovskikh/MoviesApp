package com.dmabram15.moviesapp.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dmabram15.moviesapp.click
import com.dmabram15.moviesapp.databinding.ItemMovieBinding
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.setImageFromUri

class MoviesViewHolder(
    private val binding: ItemMovieBinding,
    private val delegate: MoviesAdapter.Delegate
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        movie.poster?.let {
            binding.poster.setImageFromUri(movie.poster)
        }
        binding.apply {
            title.text = movie.title
            productionYear.text = movie.dateProduction
            root.click { delegate.onMoviePicked(movie.id) }
        }
    }
}