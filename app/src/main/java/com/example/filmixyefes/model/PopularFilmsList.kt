package com.example.filmixyefes.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularFilmsList(
    val page: Int,
    val results: List<FilmItem>,
    val total_pages: Int,
    val total_results: Int,
)