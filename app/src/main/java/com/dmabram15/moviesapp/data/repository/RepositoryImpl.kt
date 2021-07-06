package com.dmabram15.moviesapp.data.repository

import com.dmabram15.moviesapp.data.Source
import com.dmabram15.moviesapp.data.storage.Storage
import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val source: Source,
    private val storage: Storage
) : Repository {

    override fun fetchMovies(): Single<List<Movie>> =
        source.fetchMovies()
            .flatMap (storage::retainMovies)

    override fun fetchMovieById(movieId: Int): Maybe<Movie> =
        source.fetchMovieById(movieId)

    override fun retainMovies(movies: List<Movie>): Single<List<Movie>> =
        storage.retainMovies(movies)
}