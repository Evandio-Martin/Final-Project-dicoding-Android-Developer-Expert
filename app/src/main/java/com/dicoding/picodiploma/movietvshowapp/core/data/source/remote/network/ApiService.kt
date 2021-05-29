package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.network

import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.ListMovieResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.ListTvShowResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?api_key=03c50742dfea81e23849bc58f6543080")
    fun getPopularMovies(): Call<ListMovieResponse>

    @GET("tv/popular?api_key=03c50742dfea81e23849bc58f6543080")
    fun getPopularTvShows(): Call<ListTvShowResponse>
}
