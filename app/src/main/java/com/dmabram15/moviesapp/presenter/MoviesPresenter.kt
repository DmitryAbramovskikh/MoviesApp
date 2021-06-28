package com.dmabram15.moviesapp.presenter

import com.dmabram15.moviesapp.view.adapter.MoviesView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MoviesPresenter @Inject constructor() : MvpPresenter<MoviesView>() {

}