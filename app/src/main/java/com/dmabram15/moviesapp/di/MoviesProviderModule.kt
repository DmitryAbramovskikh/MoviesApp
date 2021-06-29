package com.dmabram15.moviesapp.di

import com.dmabram15.moviesapp.data.Repository
import com.dmabram15.moviesapp.data.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MoviesProviderModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository

}