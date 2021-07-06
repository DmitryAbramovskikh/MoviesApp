package com.dmabram15.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmabram15.moviesapp.model.Movie
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

@Dao
interface MoviesDAO {
    @Query("select * from movies_table")
    fun fetchMovies() : Single<List<Movie>>

    @Query("select * from movies_table where id like :id limit 1")
    fun fetchMovieById(id : Int) : Maybe<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retainMovies(movies : List<Movie>)
}