package com.dicoding.picodiploma.movietvshowapp.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.databinding.ActivityDetailMovieBinding
import com.dicoding.picodiploma.movietvshowapp.databinding.ContentDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailViewModel by viewModel()
    private lateinit var detail: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detail = detailBinding.detailContent

        setContentView(detailBinding.root)

        val detailTourism = intent.getParcelableExtra<MovieEntity>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetailTourism(detailMovie: MovieEntity?) {
        detailMovie?.let {
            detail.textTitle.text = detailMovie.title
            detail.textVoteAverage.text = "${resources.getString(R.string.vote_average)} ${detailMovie.voteAverage}"
            detail.textReleaseDate.text = "${resources.getString(R.string.release_date)} ${detailMovie.releaseDate}"
            detail.textDescription.text = detailMovie.description
            val BASE_IMG = "https://image.tmdb.org/t/p/w500"
            Glide.with(this@DetailMovieActivity)
                .load(BASE_IMG + detailMovie.poster)
                .into(detail.poster)

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            detail.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            detail.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_on))
        } else {
            detail.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_off))
        }
    }
}
