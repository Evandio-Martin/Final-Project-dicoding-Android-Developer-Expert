package com.dicoding.picodiploma.movietvshowapp.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.databinding.ActivityDetailTvShowBinding
import com.dicoding.picodiploma.movietvshowapp.databinding.ContentDetailTvShowBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTvShowViewModel: DetailViewModel by viewModel()
    private lateinit var detail: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detail = detailBinding.detailContent

        setContentView(detailBinding.root)

        val detailTourism = intent.getParcelableExtra<TvShowEntity>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    @SuppressLint("SetTextI18n")
    private fun showDetailTourism(detailTvShow: TvShowEntity?) {
        detailTvShow?.let {
            detail.textTitle.text = detailTvShow.title
            detail.textVoteAverage.text =
                "${resources.getString(R.string.vote_average)} ${detailTvShow.voteAverage}"
            detail.textReleaseDate.text =
                "${resources.getString(R.string.release_date)} ${detailTvShow.releaseDate}"
            detail.textDescription.text = detailTvShow.description
            val BASE_IMG = "https://image.tmdb.org/t/p/w500"
            Glide.with(this@DetailTvShowActivity)
                .load(BASE_IMG + detailTvShow.poster)
                .into(detail.poster)

            var statusFavorite = detailTvShow.isFavorite
            setStatusFavorite(statusFavorite)
            detail.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTvShowViewModel.setFavoriteTvShow(detailTvShow, statusFavorite)
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
