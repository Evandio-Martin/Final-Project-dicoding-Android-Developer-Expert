package com.dicoding.picodiploma.movietvshowapp.core.domain.usecase

import com.dicoding.picodiploma.movietvshowapp.core.data.Resource
import com.dicoding.picodiploma.movietvshowapp.core.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<Resource<List<Model>>>
    fun getFavoriteMovies(): Flow<List<Model>>
    fun setFavoriteMovies(model: Model, state: Boolean)

    fun getAllTvShows(): Flow<Resource<List<Model>>>
    fun getFavoriteTvShows(): Flow<List<Model>>
    fun setFavoriteTvShows(model: Model, state: Boolean)
}