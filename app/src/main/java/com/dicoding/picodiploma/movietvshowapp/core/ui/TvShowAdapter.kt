package com.dicoding.picodiploma.movietvshowapp.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.detail.DetailTvShowActivity
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.TvShowEntity
import com.dicoding.picodiploma.movietvshowapp.databinding.ItemListMovieBinding

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_tv_show, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        val BASE_IMG = "https://image.tmdb.org/t/p/w500"
        fun bind(data: TvShowEntity?) {
            with(binding) {
                if (data != null) {
                    tvItemTitle.text = data.title
                    tvVoteAverage.text = data.voteAverage.toString()
                    tvReleaseDate.text = data.releaseDate
                    Glide.with(itemView.context)
                        .load(BASE_IMG + data.poster)
                        .into(poster)
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    if (data != null) {
                        intent.putExtra(DetailTvShowActivity.EXTRA_DATA, data)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}