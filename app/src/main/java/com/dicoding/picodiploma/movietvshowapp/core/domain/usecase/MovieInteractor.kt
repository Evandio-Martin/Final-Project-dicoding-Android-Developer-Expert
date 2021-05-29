package com.dicoding.picodiploma.movietvshowapp.core.domain.usecase

import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getFavoriteMovies() = movieRepository.getFavoriteMovies()

    override fun setFavoriteMovies(model: MovieEntity, state: Boolean) = movieRepository.setFavoriteMovies(model, state)

    override fun getAllTvShows() = movieRepository.getAllTvShows()

    override fun getFavoriteTvShows() = movieRepository.getFavoriteTvShows()

    override fun setFavoriteTvShows(model: TvShowEntity, state: Boolean) = movieRepository.setFavoriteTvShows(model, state)
}