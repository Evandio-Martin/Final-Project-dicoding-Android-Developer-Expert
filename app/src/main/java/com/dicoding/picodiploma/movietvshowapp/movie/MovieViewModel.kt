package com.dicoding.picodiploma.movietvshowapp.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.movietshowapp.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovies().asLiveData()
}

