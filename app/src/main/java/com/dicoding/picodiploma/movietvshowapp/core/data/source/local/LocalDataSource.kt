package com.dicoding.picodiploma.movietvshowapp.core.data.source.local

import androidx.paging.DataSource
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.room.MovieDao

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getAllMovies()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovies()

    fun insertMovies(movieList: List<MovieEntity>) = movieDao.insertMovies(movieList)

    fun setFavoriteMovies(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovies(movie)
    }

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = movieDao.getAllTvShows()

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = movieDao.getFavoriteTvShows()

    fun insertTvShows(tvShowList: List<TvShowEntity>) = movieDao.insertTvShows(tvShowList)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        movieDao.updateFavoriteTvShows(tvShow)
    }
}