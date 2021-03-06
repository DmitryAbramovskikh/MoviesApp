package com.dmabram15.moviesapp.view

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun movies() = FragmentScreen { MoviesFragment.newInstance() }
fun movieDetail(movieId : Int) = FragmentScreen { MovieDetailFragment.newInstance(movieId) }