package com.dicoding.picodiploma.movietvshowapp.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase

class TvShowViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val tvShow = movieUseCase.getAllTvShows()
}

