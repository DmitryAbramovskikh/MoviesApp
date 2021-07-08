package com.dmabram15.moviesapp.data.storage

import com.dmabram15.moviesapp.data.Source
import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Single

interface Storage: Source {
    fun retainMovies(movies : List<Movie>) : Single<List<Movie>>
}