package com.dicoding.picodiploma.movietvshowapp.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.movietshowapp.core.domain.usecase.MovieUseCase

class TvShowViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val tvShow = movieUseCase.getAllTvShows().asLiveData()
}

