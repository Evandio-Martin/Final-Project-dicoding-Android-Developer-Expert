package com.dicoding.picodiploma.movietshowapp.core.utils

import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.movietshowapp.core.data.source.remote.response.TvShowResponse
import com.dicoding.picodiploma.movietshowapp.core.domain.model.Model

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie =
                MovieEntity(
                    description = it.description,
                    title = it.title,
                    voteAverage = it.voteAverage,
                    releaseDate = it.releaseDate,
                    poster = it.poster,
                    isFavorite = false
                )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Model> =
        input.map {
            Model(
                description = it.description,
                title = it.title,
                voteAverage = it.voteAverage,
                releaseDate = it.releaseDate,
                poster = it.poster,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Model) =
        MovieEntity(
            description = input.description,
            title = input.title,
            voteAverage = input.voteAverage,
            releaseDate = input.releaseDate,
            poster = input.poster,
            isFavorite = input.isFavorite
        )

    fun mapTvResponsesToEntities(input: List<TvShowResponse>): List<TvShowEntity> {
        val movieList = ArrayList<TvShowEntity>()
        input.map {
            val movie =
                TvShowEntity(
                    description = it.description,
                    title = it.title,
                    voteAverage = it.voteAverage,
                    releaseDate = it.releaseDate,
                    poster = it.poster,
                    isFavorite = false
                )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTvEntitiesToDomain(input: List<TvShowEntity>): List<Model> =
        input.map {
            Model(
                description = it.description,
                title = it.title,
                voteAverage = it.voteAverage,
                releaseDate = it.releaseDate,
                poster = it.poster,
                isFavorite = it.isFavorite
            )
        }

    fun mapTvDomainToEntity(input: Model) =
        TvShowEntity(
            description = input.description,
            title = input.title,
            voteAverage = input.voteAverage,
            releaseDate = input.releaseDate,
            poster = input.poster,
            isFavorite = input.isFavorite
        )
}