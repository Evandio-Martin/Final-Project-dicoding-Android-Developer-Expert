package com.dicoding.picodiploma.movietvshowapp.core.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.detail.DetailMovieActivity
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.data.source.local.entity.MovieEntity
import com.dicoding.picodiploma.movietvshowapp.databinding.ItemListMovieBinding

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<MovieEntity>()
    var onItemClick: ((MovieEntity) -> Unit)? = null

    fun setData(newListData: PagedList<MovieEntity>) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        val BASE_IMG = "https://image.tmdb.org/t/p/w500"
        fun bind(data: MovieEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(BASE_IMG + data.poster)
                    .into(poster)
                tvItemTitle.text = data.title
                tvVoteAverage.text = data.voteAverage.toString()
                tvReleaseDate.text = data.releaseDate
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                if (data != null) {
                    intent.putExtra(DetailMovieActivity.EXTRA_DATA, data)
                }
                itemView.context.startActivity(intent)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}