package com.dmabram15.moviesapp.di

import com.dmabram15.moviesapp.presenter.MovieDetailPresenter
import com.dmabram15.moviesapp.presenter.MoviesPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresentersModule {

    @Binds
    abstract fun bindMovieDetailPresenter(presenter : MovieDetailPresenter) : MovieDetailPresenter

    @Binds
    abstract fun bindMoviesPresenter(presenter : MoviesPresenter) : MoviesPresenter
}