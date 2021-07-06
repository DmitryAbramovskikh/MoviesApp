package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun fetchMovies() : Single<List<Movie>>
    fun fetchMovieById(movieId : Int) : Maybe<Movie>
}