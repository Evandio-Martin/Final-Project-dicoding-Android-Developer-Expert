package com.dicoding.picodiploma.movietvshowapp.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietvshowapp.core.data.Resource
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.usecase.MovieUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: MovieUseCase

    @Mock
    private lateinit var observerMovie: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.Success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummyMovie

        `when`(catalogRepository.getAllMovies()).thenReturn(movie)
        val movieEntity = viewModel.movie.value?.data
        verify(catalogRepository).getAllMovies()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(5, movieEntity?.size)

        viewModel.movie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }
}