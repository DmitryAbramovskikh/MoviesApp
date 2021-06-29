package com.dmabram15.moviesapp.data.api

import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("trending/movie/day")
    fun fetchTrendingMovies (
        @Query("api_key") key : String,
        @Query("language") locale : String
    ) : Single<List<Movie>>

}