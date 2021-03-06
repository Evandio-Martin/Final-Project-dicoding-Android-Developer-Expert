package com.dicoding.picodiploma.movietshowapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_favorite_tvshow")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    var title: String,

    @ColumnInfo(name = "poster_path")
    var poster: String,

    @ColumnInfo(name = "vote_average")
    var voteAverage: Double,

    @ColumnInfo(name = "first_air_date")
    var releaseDate: String,

    @ColumnInfo(name = "overview")
    var description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
