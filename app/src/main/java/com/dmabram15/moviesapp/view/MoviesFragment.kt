package com.dmabram15.moviesapp.view

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.databinding.FragmentMoviesBinding
import com.dmabram15.moviesapp.view.abs.AbsFragment

class MoviesFragment : AbsFragment(R.layout.fragment_movies) {

    private val binding: FragmentMoviesBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMovies()
    }

    private fun showMovies() {

    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}