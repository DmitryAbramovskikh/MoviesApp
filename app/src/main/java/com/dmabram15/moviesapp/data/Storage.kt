package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.model.Movie

interface Storage: Source {
    fun retainMovies(movies : List<Movie>)
}