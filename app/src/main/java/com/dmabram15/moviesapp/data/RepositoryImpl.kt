package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class RepositoryImpl() : Repository {
    override fun fetchMovies(): Single<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun fetchMovieById(movieId: String): Maybe<Movie> {
        TODO("Not yet implemented")
    }
}