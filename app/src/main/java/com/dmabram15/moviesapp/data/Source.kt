package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface Source {
    fun fetchMovies() : Single<List<Movie>>
    fun fetchMovieById(movieId : Int) : Single<Movie>
}