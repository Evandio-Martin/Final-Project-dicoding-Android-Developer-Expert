package com.dicoding.picodiploma.movietshowapp.core.data

import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.response.TvShowResponse
import com.dicoding.picodiploma.movietshowapp.core.domain.model.Model
import com.dicoding.picodiploma.movietshowapp.core.domain.repository.IMovieRepository
import com.dicoding.picodiploma.movietshowapp.core.utils.AppExecutors
import com.dicoding.picodiploma.movietshowapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: com.dicoding.picodiploma.movietshowapp.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.dicoding.picodiploma.movietshowapp.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Model>>> =
        object : com.dicoding.picodiploma.movietshowapp.core.data.NetworkBoundResource<List<Model>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Model>> {
                return localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Model>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<Model>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(movie: Model, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovies(movieEntity, state) }
    }

    override fun getAllTvShows(): Flow<Resource<List<Model>>> =
        object : com.dicoding.picodiploma.movietshowapp.core.data.NetworkBoundResource<List<Model>, List<TvShowResponse>>() {
            override fun loadFromDB(): Flow<List<Model>> {
                return localDataSource.getAllTvShows().map {
                    DataMapper.mapTvEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Model>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override suspend fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTvResponsesToEntities(data)
                localDataSource.insertTvShows(tvShowList)
            }
        }.asFlow()

    override fun getFavoriteTvShows(): Flow<List<Model>> {
        return localDataSource.getFavoriteTvShows().map {
            DataMapper.mapTvEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTvShows(movie: Model, state: Boolean) {
        val tvShowEntity = DataMapper.mapTvDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShowEntity, state) }
    }
}

