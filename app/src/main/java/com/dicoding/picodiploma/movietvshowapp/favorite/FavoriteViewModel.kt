package com.dicoding.picodiploma.movietvshowapp.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovies()

    val favoriteTvShow = movieUseCase.getFavoriteTvShows()
}

