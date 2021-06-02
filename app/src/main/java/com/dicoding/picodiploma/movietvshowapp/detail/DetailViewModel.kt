package com.dicoding.picodiploma.movietvshowapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.movietvshowapp.core.domain.model.Model
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(model: Model, newStatus: Boolean) =
        movieUseCase.setFavoriteMovies(model, newStatus)

    fun setFavoriteTvShow(model: Model, newStatus: Boolean) =
        movieUseCase.setFavoriteTvShows(model, newStatus)
}
