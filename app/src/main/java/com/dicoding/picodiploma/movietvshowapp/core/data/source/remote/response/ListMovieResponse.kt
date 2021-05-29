package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @field:SerializedName("results")
    val result: List<MovieResponse>
)