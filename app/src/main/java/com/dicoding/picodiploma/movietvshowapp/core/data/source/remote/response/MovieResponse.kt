package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val poster: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("overview")
    val description: String
)

