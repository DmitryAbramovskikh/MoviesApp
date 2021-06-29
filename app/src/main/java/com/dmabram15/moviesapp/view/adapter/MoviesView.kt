package com.dmabram15.moviesapp.view.adapter

import com.dmabram15.moviesapp.model.Movie
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface MoviesView : MvpView {
    fun showMovies(movies : List<Movie>)
    fun showMessage(message : String?)
}