package com.dicoding.picodiploma.movietvshowapp.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.network.ApiService
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.ListMovieResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.ListTvShowResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.movietvshowapp.core.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        //get data from remote api
        val client = apiService.getPopularMovies()

        client.enqueue(object : Callback<ListMovieResponse> {
            override fun onResponse(
                call: Call<ListMovieResponse>,
                response: Response<ListMovieResponse>
            ) {
                val dataArray = response.body()?.result
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListMovieResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TvShowResponse>>>()

        //get data from remote api
        val client = apiService.getPopularTvShows()

        client.enqueue(object : Callback<ListTvShowResponse> {
            override fun onResponse(
                call: Call<ListTvShowResponse>,
                response: Response<ListTvShowResponse>
            ) {
                val dataArray = response.body()?.result
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListTvShowResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}

