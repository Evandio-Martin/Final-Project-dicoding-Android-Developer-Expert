package com.dicoding.picodiploma.movietshowapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model(
    val title: String,
    val poster: String,
    val voteAverage: Double,
    val releaseDate: String,
    val description: String,
    val isFavorite: Boolean
) : Parcelable