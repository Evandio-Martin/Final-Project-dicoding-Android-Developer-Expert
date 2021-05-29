package com.dicoding.picodiploma.movietvshowapp.core.utils

import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity

object DataDummy {
    fun generateMovieDummy(): List<MovieEntity> {
        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
                "Mortal Kombat",
                "https://image.tmdb.org/t/p/w500/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                7.7,
                "Release Date: 2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
            )
        )

        return listMovie
    }

    fun generateTvShowDummy(): List<TvShowEntity> {
        val listTvShow = ArrayList<TvShowEntity>()

        listTvShow.add(
            TvShowEntity(
                "The Falcon and the Winter Soldier",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                "Release Date: 2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience."
            )
        )

        return listTvShow
    }
}