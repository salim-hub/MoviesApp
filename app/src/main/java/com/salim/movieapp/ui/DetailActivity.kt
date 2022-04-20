package com.salim.movieapp.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.salim.movieapp.databinding.ActivityDetailBinding
import com.salim.movieapp.model.Movies
import com.salim.movieapp.utils.Constants.EXTRA_MOVIE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getSerializableExtra(EXTRA_MOVIE) as Movies

        binding.movieTitle.text = movie.title
        binding.imdbRank.text = movie.voteAverage.toString() + "/10"
        binding.movieDate.text = movie.releaseDate
        binding.movieAbstract.text = movie.overview

        val url = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(this)
            .load(url)
            .into(binding.movieImage)

        binding.imdbLogo.setOnClickListener {
            val imdbUrl = "https://www.imdb.com/"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(imdbUrl)))
        }
    }
}