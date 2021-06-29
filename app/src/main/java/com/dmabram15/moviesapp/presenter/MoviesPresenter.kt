package com.dmabram15.moviesapp.presenter

import com.dmabram15.moviesapp.data.Repository
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.view.MySchedulers
import com.dmabram15.moviesapp.view.adapter.MoviesView
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MoviesPresenter @Inject constructor(private val repository : Repository) : MvpPresenter<MoviesView>() {

    override fun attachView(view: MoviesView?) {
        super.attachView(view)

        repository.fetchMovies()
            .observeOn(MySchedulers.ui())
            .subscribeOn(MySchedulers.io())
            .subscribe(
                this::fetchMoviesSuccess,
                this::fetchMoviesError
            )
    }

    private fun fetchMoviesSuccess(movies : List<Movie>) = viewState.showMovies(movies)

    private fun fetchMoviesError(error : Throwable) = viewState.showMessage(error.message)
}