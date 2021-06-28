package com.dmabram15.moviesapp.view

import com.dmabram15.moviesapp.model.Movie
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun movies() = FragmentScreen { MoviesFragment.newInstance() }
fun movieDetail(movieId : String) = FragmentScreen { MovieDetailFragment.newInstance(movieId) }