package com.dicoding.picodiploma.movietvshowapp.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: MovieUseCase

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovie = moviePagedList
        Mockito.`when`(dummyMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(catalogRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntity = viewModel.favoriteMovie.value
        Mockito.verify(catalogRepository).getFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.favoriteMovie.observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(catalogRepository.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.favoriteTvShow.value
        Mockito.verify(catalogRepository).getFavoriteTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.favoriteTvShow.observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShow)
    }
}
