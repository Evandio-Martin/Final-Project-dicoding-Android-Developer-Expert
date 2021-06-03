package com.dicoding.picodiploma.movietshowapp.core.data.source.local.room

import androidx.room.*
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM tb_favorite_movie")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM tb_favorite_movie where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movie: List<MovieEntity>)

    @Update
    fun updateFavoriteMovies(movie: MovieEntity)

    @Query("SELECT * FROM tb_favorite_tvshow")
    fun getAllTvShows(): Flow<List<TvShowEntity>>

    @Query("SELECT * FROM tb_favorite_tvshow where isFavorite = 1")
    fun getFavoriteTvShows(): Flow<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShow: List<TvShowEntity>)

    @Update
    fun updateFavoriteTvShows(tvShow: TvShowEntity)
}
