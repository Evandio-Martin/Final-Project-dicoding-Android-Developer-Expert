package com.dicoding.picodiploma.movietshowapp.core.data.source.local

import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()

    suspend fun insertMovies(movieList: List<MovieEntity>)= movieDao.insertMovies(movieList)

    fun setFavoriteMovies(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovies(movie)
    }

    fun getAllTvShows(): Flow<List<TvShowEntity>> = movieDao.getAllTvShows()

    fun getFavoriteTvShows(): Flow<List<TvShowEntity>> = movieDao.getFavoriteTvShows()

    suspend fun insertTvShows(tvShowList: List<TvShowEntity>) = movieDao.insertTvShows(tvShowList)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        movieDao.updateFavoriteTvShows(tvShow)
    }
}