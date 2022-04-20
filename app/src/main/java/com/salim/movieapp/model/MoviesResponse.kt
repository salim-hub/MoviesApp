package com.salim.movieapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MoviesResponse() {
    @SerializedName("page")
    var page = 0

    @SerializedName("results")
    var movies: List<Movies>? = null

    @SerializedName("total_results")
    var totalResults = 0

    @SerializedName("total_pages")
    var totalPages = 0
}