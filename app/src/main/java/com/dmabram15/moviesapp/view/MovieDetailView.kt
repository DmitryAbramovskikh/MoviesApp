package com.dmabram15.moviesapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.SingleState

@AddToEndSingle
interface MovieDetailView : MvpView {
    fun showPoster(url : String)
    fun showTitle(title : String)
    fun showRating(rating : String)
    fun showDescription(description : String)
}