package com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_favorite_movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "poster_path")
    val poster: String,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "overview")
    val description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
