package com.dicoding.picodiploma.movietvshowapp.core.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.LocalDataSource
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.RemoteDataSource
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.TvShowResponse
import com.dicoding.picodiploma.movietvshowapp.core.domain.model.Model
import com.dicoding.picodiploma.movietvshowapp.core.domain.repository.IMovieRepository
import com.dicoding.picodiploma.movietvshowapp.core.utils.AppExecutors
import com.dicoding.picodiploma.movietvshowapp.core.utils.DataMapper

class FakeMovieRepository(
    private val remoteDataSource: com.dicoding.picodiploma.movietshowapp.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.dicoding.picodiploma.movietshowapp.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors?
) : IMovieRepository {

    override fun getAllMovies(): LiveData<com.dicoding.picodiploma.movietshowapp.core.data.Resource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>>> =
        object : com.dicoding.picodiploma.movietshowapp.core.data.NetworkBoundResource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteMovies(): LiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun setFavoriteMovies(movie: Model, state: Boolean) {
    }

    override fun getAllTvShows(): LiveData<com.dicoding.picodiploma.movietshowapp.core.data.Resource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>>> =
        object : com.dicoding.picodiploma.movietshowapp.core.data.NetworkBoundResource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tourismList = DataMapper.mapTvResponsesToEntities(data)
                localDataSource.insertTvShows(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteTvShows(): LiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteTvShows(movie: Model, state: Boolean) {
    }
}

