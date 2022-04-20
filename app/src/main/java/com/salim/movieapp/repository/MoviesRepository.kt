package com.salim.movieapp.repository

import com.salim.movieapp.model.MoviesResponse
import com.salim.movieapp.service.MovieAppService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val appService: MovieAppService
) {

    suspend fun fetchNowPlayingMovies(apikey: String): Response<MoviesResponse> = withContext(
        Dispatchers.IO) {
        val nowPlaying = appService.getNowPlayingMovies(apikey)
        nowPlaying
    }

    suspend fun fetchUpcomingMovies(apikey: String): Response<MoviesResponse> = withContext(
        Dispatchers.IO) {
        val upcoming = appService.getUpcomingMovies(apikey)
        upcoming
    }
}