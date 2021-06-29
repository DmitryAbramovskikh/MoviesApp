package com.dmabram15.moviesapp.data.api

import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.model.ResultDTO
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("trending/movie/day")
    fun fetchTrendingMovies (
        @Query("api_key") key : String,
        @Query("language") locale : String
    ) : Single<ResultDTO>

    @GET("movie/{id}")
    fun fetchMovieById (
        @Query("api_key") key : String,
        @Path("id") id : Int
    ) : Maybe<Movie>
}