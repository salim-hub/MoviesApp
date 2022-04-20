package com.salim.movieapp.service

import com.salim.movieapp.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAppService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String?): Response<MoviesResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String?): Response<MoviesResponse>
}