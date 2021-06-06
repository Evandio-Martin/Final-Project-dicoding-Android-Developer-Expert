package com.dicoding.picodiploma.movietvshowapp.favorite.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.movietshowapp.core.ui.MovieAdapter
import com.dicoding.picodiploma.movietvshowapp.detail.DetailTvShowActivity
import com.dicoding.picodiploma.movietvshowapp.favorite.databinding.FragmentFavoriteTvShowBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteTvShowFragment : Fragment() {

    private val favoriteTvShowViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val tvShowAdapter = MovieAdapter()
            tvShowAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteTvShowViewModel.favoriteTvShow.observe(viewLifecycleOwner, { dataTvShow ->
                tvShowAdapter.setData(dataTvShow)
                binding.viewEmpty.root.visibility =
                    if (dataTvShow.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvFavoriteTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
