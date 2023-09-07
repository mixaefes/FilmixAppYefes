package com.example.filmixyefes.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NowPlayingFilmsList(
    val page: Int,
    val dates: Dates,
    val results: List<FilmItem>,
    val total_pages: Int,
    val total_results: Int,
)

@JsonClass(generateAdapter = true)
data class Dates(
    val maximum: String,
    val minimum: String
)

