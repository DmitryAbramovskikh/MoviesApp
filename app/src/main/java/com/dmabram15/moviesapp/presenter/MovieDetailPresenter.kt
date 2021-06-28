package com.dmabram15.moviesapp.presenter

import com.dmabram15.moviesapp.view.MovieDetailView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MovieDetailPresenter @Inject constructor() : MvpPresenter<MovieDetailView>() {

    fun setMovie(movieId : String) {
        TODO("Not implement yet")
    }
}