package com.dmabram15.moviesapp.view

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object MySchedulers {
    fun io() = Schedulers.io()
    fun ui() = AndroidSchedulers.mainThread()
}