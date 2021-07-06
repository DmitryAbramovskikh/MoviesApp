package com.dmabram15.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.dmabram15.moviesapp.data.CloudSource
import com.dmabram15.moviesapp.data.Source
import com.dmabram15.moviesapp.data.api.MoviesApi
import com.dmabram15.moviesapp.data.db.MoviesDatabase
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [MoviesUiModule::class])
class MoviesModule {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().also {
                            it.level = HttpLoggingInterceptor.Level.BODY
                        })
                    .build())
            .build()
            .create(MoviesApi::class.java)

    @Singleton
    @Provides
    fun provideCloudSource() : Source = CloudSource(retrofit)

    @Singleton
    @Provides
    fun provideDatabase(context : Context) : MoviesDatabase =
        Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            "MoviesDb.db"
        ).build()
}