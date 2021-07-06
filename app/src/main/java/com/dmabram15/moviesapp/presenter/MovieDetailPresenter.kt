package com.dmabram15.moviesapp.presenter

import android.util.Log
import com.dmabram15.moviesapp.data.Repository
import com.dmabram15.moviesapp.data.Storage
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.view.MovieDetailView
import com.dmabram15.moviesapp.view.MySchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MovieDetailPresenter @Inject constructor(
    private val repository: Repository,
    private val storage: Storage
) : MvpPresenter<MovieDetailView>() {

    private val disposables = CompositeDisposable()

    fun setMovie(movieId: Int) {
        disposables.add(
            (storage.fetchMovieById(movieId)
                .subscribeOn(MySchedulers.io())
                .observeOn(MySchedulers.ui())
                .subscribe(this::fetchMovieSuccess))
        )
        disposables.add(
            repository.fetchMovieById(movieId)
                .subscribeOn(MySchedulers.io())
                .observeOn(MySchedulers.ui())
                .subscribe(
                    this::fetchMovieSuccess,
                    this::fetchMovieError
                )
        )
    }

    private fun fetchMovieSuccess(movie: Movie) {
        movie.poster?.let { uri ->
            viewState.showPoster(uri)
        }
        with(viewState) {
            showDescription(movie.description)
            showRating(movie.rating)
            showTitle(movie.title)
        }
    }

    private fun fetchMovieError(error: Throwable) {
        error.message?.let { Log.d("TAG", it) }
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}