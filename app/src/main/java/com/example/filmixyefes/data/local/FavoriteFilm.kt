package com.example.filmixyefes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteFilm(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var adult: Boolean? = false,
    var backdropPath: String? = null,
    var originalLanguage: String? = null,
    var title: String? = null,
    var overview: String? = null,
    var popularity: Float? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var voteAverage: Float? = null,
    var isFavorite: Boolean = false
)
