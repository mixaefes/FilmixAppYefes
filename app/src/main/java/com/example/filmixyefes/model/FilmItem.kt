package com.example.filmixyefes.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmItem(
    val adult: Boolean,
    @field:Json(name = "backdrop_path") val backdrop_path: String,
    val id: Int,
    @field:Json(name = "original_language") val original_language: String,
    @field:Json(name = "original_title") val title: String,
    val overview: String,
    val popularity: Float,
    @field:Json(name = "poster_path") val poster_path: String,
    @field:Json(name = "release_date") val releaseDate: String,
    @field:Json(name = "vote_average") val vote_average: Float,
)
