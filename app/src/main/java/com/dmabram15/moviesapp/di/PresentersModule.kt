package com.dmabram15.moviesapp.di

import com.dmabram15.moviesapp.presenter.MovieDetailPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresentersModule {

    @Binds
    abstract fun bindMovieDetail(presenter : MovieDetailPresenter) : MovieDetailPresenter

}