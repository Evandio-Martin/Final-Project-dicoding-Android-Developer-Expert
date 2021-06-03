package com.dicoding.picodiploma.movietshowapp.core.domain.usecase

import com.dicoding.picodiploma.movietshowapp.core.domain.model.Model
import com.dicoding.picodiploma.movietshowapp.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getFavoriteMovies() = movieRepository.getFavoriteMovies()

    override fun setFavoriteMovies(model: Model, state: Boolean) =
        movieRepository.setFavoriteMovies(model, state)

    override fun getAllTvShows() = movieRepository.getAllTvShows()

    override fun getFavoriteTvShows() = movieRepository.getFavoriteTvShows()

    override fun setFavoriteTvShows(model: Model, state: Boolean) =
        movieRepository.setFavoriteTvShows(model, state)
}