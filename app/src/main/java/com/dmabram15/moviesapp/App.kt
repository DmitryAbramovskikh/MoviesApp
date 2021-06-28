package com.dmabram15.moviesapp

import com.dmabram15.moviesapp.di.DaggerAppComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent.builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNaviHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
            }
            .build()

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}