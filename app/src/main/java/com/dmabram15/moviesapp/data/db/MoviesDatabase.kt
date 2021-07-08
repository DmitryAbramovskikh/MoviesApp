package com.dmabram15.moviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmabram15.moviesapp.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun moviesDao() : MoviesDAO
}