package com.dmabram15.moviesapp.di

import com.dmabram15.moviesapp.view.ContainerActivity
import com.dmabram15.moviesapp.view.MovieDetailFragment
import com.dmabram15.moviesapp.view.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesUiModule {

    @ContributesAndroidInjector
    abstract fun bindMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun bindMovieDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    abstract fun bindContainerActivity(): ContainerActivity

}