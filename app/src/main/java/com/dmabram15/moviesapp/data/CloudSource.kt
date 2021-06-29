package com.dmabram15.moviesapp.data

import com.dmabram15.moviesapp.BuildConfig
import com.dmabram15.moviesapp.data.api.MoviesApi
import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class CloudSource (private val moviesApi: MoviesApi) : Source {
    private val apiKey : String = BuildConfig.TMDB_API_KEY
    private val locale : String = "ru-RU"

    override fun fetchMovies(): Single<List<Movie>> = moviesApi.fetchTrendingMovies(apiKey, locale)

    override fun fetchMovieById(movieId: Int): Maybe<Movie> = moviesApi.fetchMovieById(apiKey, movieId)
}