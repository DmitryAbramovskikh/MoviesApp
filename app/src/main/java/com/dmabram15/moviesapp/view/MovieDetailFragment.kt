package com.dmabram15.moviesapp.view

import by.kirich1409.viewbindingdelegate.viewBinding
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.databinding.FragmentMovieDetailBinding
import com.dmabram15.moviesapp.view.abs.AbsFragment

class MovieDetailFragment : AbsFragment(R.layout.fragment_movie_detail) {

    private val binding : FragmentMovieDetailBinding by viewBinding()

    companion object {
        fun newInstance() = MovieDetailFragment()
    }
}