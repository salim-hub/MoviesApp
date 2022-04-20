package com.salim.movieapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "movies")
class Movies() :  Serializable {
    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double? = null
}