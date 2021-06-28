package com.dmabram15.moviesapp.view

import by.kirich1409.viewbindingdelegate.viewBinding
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.databinding.FragmentMoviesBinding
import com.dmabram15.moviesapp.view.abs.AbsFragment

class MoviesFragment : AbsFragment(R.layout.fragment_movies) {

    private val binding: FragmentMoviesBinding by viewBinding()

    companion object {
        fun newInstance() = MoviesFragment()
    }
}