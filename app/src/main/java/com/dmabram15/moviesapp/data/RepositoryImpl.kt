package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val source: Source
) : Repository {
    override fun fetchMovies(): Single<List<Movie>> = source.fetchMovies()

    override fun fetchMovieById(movieId: String): Maybe<Movie> {
        TODO("Not yet implemented")
    }
}