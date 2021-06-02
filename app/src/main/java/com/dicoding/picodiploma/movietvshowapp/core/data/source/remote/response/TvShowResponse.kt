package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("poster_path")
    val poster: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("first_air_date")
    val releaseDate: String,

    @field:SerializedName("overview")
    val description: String
)

