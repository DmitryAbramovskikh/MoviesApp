package com.dmabram15.moviesapp.view

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.dmabram15.moviesapp.R
import com.dmabram15.moviesapp.data.repository.Repository
import com.dmabram15.moviesapp.databinding.FragmentMoviesBinding
import com.dmabram15.moviesapp.model.Movie
import com.dmabram15.moviesapp.presenter.MoviesPresenter
import com.dmabram15.moviesapp.view.abs.AbsFragment
import com.dmabram15.moviesapp.view.adapter.MoviesAdapter
import com.dmabram15.moviesapp.view.adapter.MoviesView
import com.github.terrakok.cicerone.Router
import com.google.android.material.snackbar.Snackbar
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MoviesFragment : AbsFragment(R.layout.fragment_movies), MoviesView, MoviesAdapter.Delegate {

    private val binding: FragmentMoviesBinding by viewBinding()
    private lateinit var adapter: MoviesAdapter

    @Inject
    lateinit var router : Router

    @Inject
    lateinit var repository: Repository

    @InjectPresenter
    lateinit var presenter: MoviesPresenter

    @ProvidePresenter
    fun providePresenter() : MoviesPresenter {
        return MoviesPresenter(repository, router)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }

    override fun showMovies(movies: List<Movie>) {
        adapter.submitList(movies)
    }

    override fun showMessage(message: String?) {
        message?.let {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT)
        }
    }

    private fun initRecycler() {
        adapter = MoviesAdapter(this)
        binding.moviesRV.adapter = adapter
    }

    override fun onMoviePicked(movieId: Int) {
        presenter.displayMovie(movieId)
    }
}