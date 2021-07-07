package com.dmabram15.moviesapp.view

import android.os.Bundle
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.view.abs.AbsActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class ContainerActivity : AbsActivity(R.layout.activity_container) {

    @Inject
    lateinit var router: Router

    private val navigator by lazy {
        AppNavigator(this, R.id.container, supportFragmentManager)
    }

    @Inject
    lateinit var navHolder : NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        savedInstanceState ?: router.newRootScreen(movies())
    }

    override fun onResume() {
        super.onResume()
        navHolder.setNavigator(navigator)
    }

    override fun onDestroy() {
        super.onDestroy()
        navHolder.removeNavigator()
    }
}