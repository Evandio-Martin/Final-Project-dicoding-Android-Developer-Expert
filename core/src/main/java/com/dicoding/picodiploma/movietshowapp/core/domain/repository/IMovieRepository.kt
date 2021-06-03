package com.dicoding.picodiploma.movietshowapp.core.domain.repository

import com.dicoding.picodiploma.movietshowapp.core.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<com.dicoding.picodiploma.movietshowapp.core.data.Resource<List<Model>>>

    fun getFavoriteMovies(): Flow<List<Model>>

    fun setFavoriteMovies(movie: Model, state: Boolean)

    fun getAllTvShows(): Flow<com.dicoding.picodiploma.movietshowapp.core.data.Resource<List<Model>>>

    fun getFavoriteTvShows(): Flow<List<Model>>

    fun setFavoriteTvShows(movie: Model, state: Boolean)

}