package com.dicoding.picodiploma.movietvshowapp.core.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.LocalDataSource
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.RemoteDataSource
import com.dicoding.picodiploma.movietvshowapp.core.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(com.dicoding.picodiploma.movietshowapp.core.data.source.remote.RemoteDataSource::class.java)
    private val local = Mockito.mock(com.dicoding.picodiploma.movietshowapp.core.data.source.local.LocalDataSource::class.java)
    private val catalogRepository = FakeMovieRepository(remote, local, null)

    private val listMovie = DataDummy.generateMovieDummy()
    private val listTvShow = DataDummy.generateTvShowDummy()


    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>
        Mockito.`when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        catalogRepository.getAllMovies()

        val movieEntity =
            com.dicoding.picodiploma.movietshowapp.core.data.Resource.Success(PagedListUtil.mockPagedList(DataDummy.generateMovieDummy()))
        Mockito.verify(local).getAllMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>
        Mockito.`when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteMovies()

        val movieEntity =
            com.dicoding.picodiploma.movietshowapp.core.data.Resource.Success(PagedListUtil.mockPagedList(DataDummy.generateMovieDummy()))
        Mockito.verify(local).getFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>
        Mockito.`when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        catalogRepository.getAllTvShows()

        val tvShowEntity =
            com.dicoding.picodiploma.movietshowapp.core.data.Resource.Success(PagedListUtil.mockPagedList(DataDummy.generateTvShowDummy()))
        Mockito.verify(local).getAllTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>
        Mockito.`when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogRepository.getFavoriteTvShows()

        val tvShowEntity =
            com.dicoding.picodiploma.movietshowapp.core.data.Resource.Success(PagedListUtil.mockPagedList(DataDummy.generateTvShowDummy()))
        Mockito.verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }
}