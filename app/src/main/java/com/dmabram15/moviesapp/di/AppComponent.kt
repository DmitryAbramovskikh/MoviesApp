package com.dmabram15.moviesapp.di

import android.content.Context
import com.dmabram15.moviesapp.App
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        PresentersModule::class,
        MoviesProviderModule::class,
        MoviesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withNaviHolder(holder: NavigatorHolder): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        fun build(): AppComponent

    }
}