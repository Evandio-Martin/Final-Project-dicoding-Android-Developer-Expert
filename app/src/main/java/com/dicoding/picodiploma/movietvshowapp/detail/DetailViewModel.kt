package com.dicoding.picodiploma.movietvshowapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(model: MovieEntity, newStatus: Boolean) =
        movieUseCase.setFavoriteMovies(model, newStatus)

    fun setFavoriteTvShow(model: TvShowEntity, newStatus: Boolean) =
        movieUseCase.setFavoriteTvShows(model, newStatus)
}
