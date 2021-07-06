package com.dmabram15.moviesapp.presenter

import com.dmabram15.moviesapp.data.Repository
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.view.MySchedulers
import com.dmabram15.moviesapp.view.adapter.MoviesView
import com.dmabram15.moviesapp.view.movieDetail
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MoviesPresenter(
    private val repository: Repository,
    private val router: Router
) : MvpPresenter<MoviesView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables.add(
            repository.fetchMovies()
                .observeOn(MySchedulers.ui())
                .subscribeOn(MySchedulers.io())
                .subscribe(
                    this::fetchMoviesSuccess,
                    this::fetchMoviesError
                )
        )
    }

    private fun fetchMoviesSuccess(movies: List<Movie>) = viewState.showMovies(movies)

    private fun fetchMoviesError(error: Throwable) = viewState.showMessage(error.message)

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun displayMovie(movieId: Int) {
        router.navigateTo(movieDetail(movieId))
    }
}