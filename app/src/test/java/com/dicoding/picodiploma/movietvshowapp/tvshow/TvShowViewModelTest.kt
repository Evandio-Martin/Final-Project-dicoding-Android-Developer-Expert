package com.dicoding.picodiploma.movietvshowapp.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.picodiploma.movietvshowapp.core.data.Resource
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: MovieUseCase

    @Mock
    private lateinit var observerTvShow: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = Resource.Success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(5)
        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = dummyTvShow

        `when`(catalogRepository.getAllTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.tvShow.value?.data
        verify(catalogRepository).getAllTvShows()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(5, tvShowEntity?.size)

        viewModel.tvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}