package com.dicoding.picodiploma.movietvshowapp.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietvshowapp.core.data.Resource
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity

interface MovieUseCase {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>
    fun setFavoriteMovies(model: MovieEntity, state: Boolean)

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>
    fun setFavoriteTvShows(model: TvShowEntity, state: Boolean)
}