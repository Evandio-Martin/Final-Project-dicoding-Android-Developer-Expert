package com.dicoding.picodiploma.movietvshowapp.movie

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovies()
}

