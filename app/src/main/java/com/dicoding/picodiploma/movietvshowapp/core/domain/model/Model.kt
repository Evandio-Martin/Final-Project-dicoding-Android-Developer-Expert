package com.dicoding.picodiploma.movietvshowapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Model(
    var title: String,
    var poster: String,
    var voteAverage: Double,
    var releaseDate: String,
    var description: String,
    val isFavorite: Boolean
) : Parcelable