package com.dicoding.picodiploma.movietvshowapp.core.domain.repository

import com.dicoding.picodiploma.movietvshowapp.core.data.Resource
import com.dicoding.picodiploma.movietvshowapp.core.domain.model.Model
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Model>>>

    fun getFavoriteMovies(): Flow<List<Model>>

    fun setFavoriteMovies(movie: Model, state: Boolean)

    fun getAllTvShows(): Flow<Resource<List<Model>>>

    fun getFavoriteTvShows(): Flow<List<Model>>

    fun setFavoriteTvShows(movie: Model, state: Boolean)

}