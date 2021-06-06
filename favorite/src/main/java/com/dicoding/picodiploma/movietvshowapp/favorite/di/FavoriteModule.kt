package com.dicoding.picodiploma.movietvshowapp.favorite.di

import com.dicoding.picodiploma.movietvshowapp.favorite.fragment.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}