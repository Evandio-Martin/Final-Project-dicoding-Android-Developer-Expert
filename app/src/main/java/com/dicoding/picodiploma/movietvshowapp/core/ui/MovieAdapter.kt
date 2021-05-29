package com.dicoding.picodiploma.movietvshowapp.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.detail.DetailMovieActivity
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.databinding.ItemListMovieBinding

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        val BASE_IMG = "https://image.tmdb.org/t/p/w500"
        fun bind(data: MovieEntity) {
            with(binding) {
                if (data != null) {
                    tvItemTitle.text = data.title
                    tvReleaseDate.text = data.releaseDate
                    tvVoteAverage.text = data.voteAverage.toString()
                    Glide.with(itemView.context)
                        .load(BASE_IMG + data.poster)
                        .into(poster)
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    if (data != null) {
                        intent.putExtra(DetailMovieActivity.EXTRA_DATA, data)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}