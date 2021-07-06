package com.dmabram15.moviesapp.view

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.data.repository.Repository
import com.dmabram15.moviesapp.databinding.FragmentMovieDetailBinding
import com.dmabram15.moviesapp.presenter.MovieDetailPresenter
import com.dmabram15.moviesapp.setImageFromUri
import com.dmabram15.moviesapp.view.abs.AbsFragment
import javax.inject.Inject

const val MOVIE_ID_KEY = "movieId"

class MovieDetailFragment : AbsFragment(R.layout.fragment_movie_detail), MovieDetailView {

    private val binding : FragmentMovieDetailBinding by viewBinding()

    @Inject
    lateinit var presenter : MovieDetailPresenter

    @Inject
    lateinit var repository: Repository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.run {
            presenter.setMovie(this.getInt(MOVIE_ID_KEY, -1))
        }
    }

    override fun showPoster(url : String) {
        binding.poster.setImageFromUri(url)
    }

    override fun showTitle(title: String) {
        binding.title.text = title
    }

    override fun showRating(rating: String) {
        binding.rating.text = rating
    }

    override fun showDescription(description: String) {
        binding.description.text = description
    }

    companion object {
        fun newInstance(movieId: Int) : MovieDetailFragment {
            val arguments = Bundle()
            arguments.putInt(MOVIE_ID_KEY, movieId)
            return MovieDetailFragment().apply{
                this.arguments = arguments
            }
        }
    }
}