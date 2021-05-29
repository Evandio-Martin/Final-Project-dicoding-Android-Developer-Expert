package com.dicoding.picodiploma.movietvshowapp.core.data.source.local.room

import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM tb_favorite_movie")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tb_favorite_movie where isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieEntity>)

    @Update
    fun updateFavoriteMovies(movie: MovieEntity)

    @Query("SELECT * FROM tb_favorite_tvshow")
    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tb_favorite_tvshow where isFavorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShow: List<TvShowEntity>)

    @Update
    fun updateFavoriteTvShows(tvShow: TvShowEntity)
}
