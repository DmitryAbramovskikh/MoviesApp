package com.dmabram15.moviesapp.view

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun movies() = FragmentScreen { MoviesFragment.newInstance() }
fun movieDetail() = FragmentScreen { MovieDetailFragment() }