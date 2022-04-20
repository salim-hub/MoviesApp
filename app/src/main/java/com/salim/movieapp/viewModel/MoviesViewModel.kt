package com.salim.movieapp.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salim.movieapp.model.MoviesResponse
import com.salim.movieapp.repository.MoviesRepository
import com.salim.movieapp.service.MovieAppService
import com.salim.movieapp.utils.Constants.API_KEY
import com.salim.movieapp.utils.Resource
import com.salim.movieapp.utils.hasInternetConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val movieNowPlaying: MutableLiveData<Resource<MoviesResponse>> = MutableLiveData()
    val upcomingMovies: MutableLiveData<Resource<MoviesResponse>> = MutableLiveData()

    private val disposable = CompositeDisposable()

    fun fetchNowPlaying(apikey: String){
        movieNowPlaying.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                if (hasInternetConnection(context)) {
                    val response = repository.fetchNowPlayingMovies(apikey)
                    movieNowPlaying.postValue(Resource.Success(response.body()!!))
                } else
                    movieNowPlaying.postValue(Resource.Error("Internet Connection Error"))
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> movieNowPlaying.postValue(Resource.Error("Network Failure " +  ex.localizedMessage))
                    else -> movieNowPlaying.postValue(Resource.Error("Conversion Error"))
                }
            }
        }
    }

    fun fetchUpcoming(apikey: String) {
        upcomingMovies.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                if (hasInternetConnection(context)) {
                    val response = repository.fetchUpcomingMovies(apikey)
                    upcomingMovies.postValue(Resource.Success(response.body()!!))
                } else
                    upcomingMovies.postValue(Resource.Error("Internet Connection Error"))
            } catch (ex: Exception) {
                when (ex) {
                    is IOException -> upcomingMovies.postValue(Resource.Error("Network Failure " +  ex.localizedMessage))
                    else -> upcomingMovies.postValue(Resource.Error("Conversion Error"))
                }
            }
        }
    }
}