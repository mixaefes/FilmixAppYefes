package com.example.filmixyefes.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmItem(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val title: String,
    val overview: String,
    val popularity: Float,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Float,
)
