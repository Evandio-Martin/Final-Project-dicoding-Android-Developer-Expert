package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val poster: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("overview")
    val description: String
)

