package com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_favorite_movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster_path")
    var poster: String,

    @ColumnInfo(name = "vote_average")
    var voteAverage: Double,

    @ColumnInfo(name = "release_date")
    var releaseDate: String,

    @ColumnInfo(name = "overview")
    var description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
