package com.dicoding.picodiploma.movietvshowapp.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietshowapp.core.data.Resource
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: MovieUseCase

    private val viewModel by lazy { MovieViewModel(useCase) }

    @Mock
    private lateinit var observerMovie: Observer<com.dicoding.picodiploma.movietshowapp.core.data.Resource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>

    @Before
    fun setUp() {
        reset(useCase)
    }

    @Test
    fun getMovie() {
        val dummyMovie = com.dicoding.picodiploma.movietshowapp.core.data.Resource.Success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(5)
        val movie = MutableLiveData<com.dicoding.picodiploma.movietshowapp.core.data.Resource<PagedList<com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity>>>()
        movie.value = dummyMovie

        `when`(useCase.getAllMovies()).thenReturn(movie)
        val movieEntity = viewModel.movie.value?.data
        verify(useCase).getAllMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.movie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }
}