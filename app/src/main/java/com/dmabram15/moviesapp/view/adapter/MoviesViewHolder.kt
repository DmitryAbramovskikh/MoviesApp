package com.dmabram15.moviesapp.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dmabram15.moviesapp.databinding.ItemMovieBinding
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.setImageFromUri

class MoviesViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.apply {
            poster.setImageFromUri(movie.poster)
            title.text = movie.title
            productionYear.text = movie.dateProduction
        }
    }
}