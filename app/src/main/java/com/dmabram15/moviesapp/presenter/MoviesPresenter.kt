package com.dmabram15.moviesapp.presenter

import com.dmabram15.moviesapp.data.Repository
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.view.MySchedulers
import com.dmabram15.moviesapp.view.adapter.MoviesView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MoviesPresenter (private val repository : Repository) : MvpPresenter<MoviesView>() {

    private val disposables  = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables.add (
            repository.fetchMovies()
            .observeOn(MySchedulers.ui())
            .subscribeOn(MySchedulers.io())
            .subscribe(
                this::fetchMoviesSuccess,
                this::fetchMoviesError
            )
        )
    }

    private fun fetchMoviesSuccess(movies : List<Movie>) = viewState.showMovies(movies)

    private fun fetchMoviesError(error : Throwable) = viewState.showMessage(error.message)

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}