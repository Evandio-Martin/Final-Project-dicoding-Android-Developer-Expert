package com.dicoding.picodiploma.movietvshowapp.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.reset
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: MovieUseCase

    private val viewModel by lazy { FavoriteViewModel(useCase) }

    @Mock
    private lateinit var observerMovie: Observer<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>

    @Before
    fun setUp() {
        reset(useCase)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovie = moviePagedList
        Mockito.`when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(useCase.getFavoriteMovies()).thenReturn(movie)
        val movieEntity = viewModel.favoriteMovie.value
        Mockito.verify(useCase).getFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.favoriteMovie.observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(useCase.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.favoriteTvShow.value
        Mockito.verify(useCase).getFavoriteTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.favoriteTvShow.observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShow)
    }
}
