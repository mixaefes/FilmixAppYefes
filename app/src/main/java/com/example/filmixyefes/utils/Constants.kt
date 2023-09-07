package com.example.filmixyefes.utils

import com.example.filmixyefes.model.FilmItem
import com.example.filmixyefes.model.PopularFilmsList

object Constants {

    const val DATABASE_NAME = "films_database"
    const val BASE_URI = "https://api.themoviedb.org/3/movie/"
    const val API_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmMxM2QyYzllNGJiM2JhODRmZDI1ZTE4NTAxNDNmMSIsInN1YiI6IjY0ZjVjYjhkZjI5ZDY2MDBjNjZhYWU1NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NdOere7PYGu-ReC_e-N9LMYTsP7_fPrN4Fz_wGmrtus"
    const val API_KEY = "2c46288716a18fb7aadcc2a801f3fc6b"
    const val BASE_IMAGE_URI = "https://image.tmdb.org/t/p/w500/"
    val EMPTY_FILM_ITEM = FilmItem(
        adult = false,
        backdrop_path = "",
        id = 0,
        original_language = "",
        title = "",
        overview = "",
        popularity = 0f,
        poster_path = "",
        releaseDate = "",
        vote_average = 0f
    )
    val EMPTY_FILM_LIST_RESULT =  PopularFilmsList(
        page = 0,
        results = emptyList(),
        total_pages = 1,
        total_results = 1
    )
}