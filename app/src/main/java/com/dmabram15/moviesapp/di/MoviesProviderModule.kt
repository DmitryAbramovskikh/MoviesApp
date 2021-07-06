package com.dmabram15.moviesapp.di

import com.dmabram15.moviesapp.data.repository.Repository
import com.dmabram15.moviesapp.data.repository.RepositoryImpl
import com.dmabram15.moviesapp.data.storage.DatabaseStorage
import com.dmabram15.moviesapp.data.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class MoviesProviderModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl) : Repository

    @Binds
    abstract fun bindStorage(storage: DatabaseStorage) : Storage
}