package com.dmabram15.moviesapp.data.storage

import com.dmabram15.moviesapp.data.db.MoviesDatabase
import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DatabaseStorage @Inject constructor(
    private val database : MoviesDatabase
) : Storage {

    override fun retainMovies(movies: List<Movie>): Single<List<Movie>> {
        database.moviesDao().retainMovies(movies)
        return Single.just(movies)
    }

    override fun fetchMovies(): Single<List<Movie>> =
        database.moviesDao().fetchMovies()

    override fun fetchMovieById(movieId: Int): Maybe<Movie> =
        database.moviesDao().fetchMovieById(movieId)
}