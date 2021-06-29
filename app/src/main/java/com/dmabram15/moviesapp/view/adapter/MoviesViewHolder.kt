package com.dmabram15.moviesapp.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dmabram15.moviesapp.databinding.ItemMovieBinding
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.setImageFromUri

const val IMAGE_URI_PREFIX = "https://image.tmdb.org/t/p/w500/"

class MoviesViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        movie.poster?.let {
            val fullUri = "$IMAGE_URI_PREFIX$it"
            binding.poster.setImageFromUri(fullUri)
        }
        binding.apply {
            title.text = movie.title
            productionYear.text = movie.dateProduction
        }
    }
}