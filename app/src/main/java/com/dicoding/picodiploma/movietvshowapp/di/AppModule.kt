package com.dicoding.picodiploma.movietvshowapp.di

import com.dicoding.picodiploma.movietshowapp.core.domain.usecase.MovieInteractor
import com.dicoding.picodiploma.movietshowapp.core.domain.usecase.MovieUseCase
import com.dicoding.picodiploma.movietvshowapp.detail.DetailViewModel
import com.dicoding.picodiploma.movietvshowapp.movie.MovieViewModel
import com.dicoding.picodiploma.movietvshowapp.tvshow.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}