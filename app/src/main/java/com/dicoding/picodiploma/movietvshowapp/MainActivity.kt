package com.dicoding.movietvshowapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.dicoding.picodiploma.movietvshowapp.R
import com.dicoding.picodiploma.movietvshowapp.databinding.ActivityMainBinding
import com.dicoding.picodiploma.movietvshowapp.favorite.FavoriteMovieFragment
import com.dicoding.picodiploma.movietvshowapp.favorite.FavoriteTvShowFragment
import com.dicoding.picodiploma.movietvshowapp.movie.MovieFragment
import com.dicoding.picodiploma.movietvshowapp.tvshow.TvShowFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, MovieFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_movie -> {
                fragment = MovieFragment()
                title = getString(R.string.movie)
            }
            R.id.nav_tv_show -> {
                fragment = TvShowFragment()
                title = getString(R.string.tv_show)
            }
            R.id.nav_favorite_movie -> {
                fragment = FavoriteMovieFragment()
                title = getString(R.string.menu_favorite_movies)
            }
            R.id.nav_favorite_tv_show -> {
                fragment = FavoriteTvShowFragment()
                title = getString(R.string.menu_favorite_tv_show)
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

