package com.dicoding.picodiploma.movietvshowapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.movietshowapp.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovies().asLiveData()

    val favoriteTvShow = movieUseCase.getFavoriteTvShows().asLiveData()
}

