package com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_favorite_tvshow")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    val title: String,

    @ColumnInfo(name = "poster_path")
    val poster: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "first_air_date")
    val releaseDate: String,

    @ColumnInfo(name = "overview")
    val description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
