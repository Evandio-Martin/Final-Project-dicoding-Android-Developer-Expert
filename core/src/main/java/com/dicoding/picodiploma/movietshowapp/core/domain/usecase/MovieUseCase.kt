package com.dicoding.picodiploma.movietshowapp.core.domain.usecase

import com.dicoding.picodiploma.movietshowapp.core.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<com.dicoding.picodiploma.movietshowapp.core.data.Resource<List<Model>>>
    fun getFavoriteMovies(): Flow<List<Model>>
    fun setFavoriteMovies(model: Model, state: Boolean)

    fun getAllTvShows(): Flow<com.dicoding.picodiploma.movietshowapp.core.data.Resource<List<Model>>>
    fun getFavoriteTvShows(): Flow<List<Model>>
    fun setFavoriteTvShows(model: Model, state: Boolean)
}