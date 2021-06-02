package com.dicoding.picodiploma.movietvshowapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.core.domain.model.Model
import com.dicoding.picodiploma.movietvshowapp.databinding.ItemListMovieBinding
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Model>()
    var onItemClick: ((Model) -> Unit)? = null

    fun setData(newListData: List<Model>?) {
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
        fun bind(data: Model) {
            with(binding) {
                tvItemTitle.text = data.title
                tvReleaseDate.text = data.releaseDate
                tvVoteAverage.text = data.voteAverage.toString()
                Glide.with(itemView.context)
                    .load(BASE_IMG + data.poster)
                    .into(poster)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}