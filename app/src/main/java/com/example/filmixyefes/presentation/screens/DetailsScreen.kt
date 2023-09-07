package com.example.filmixyefes.presentation.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.filmixyefes.R
import com.example.filmixyefes.data.local.FavoriteFilm
import com.example.filmixyefes.presentation.viewmodels.FilmsViewModel
import com.example.filmixyefes.utils.Constants

@Composable
fun DetailsScreen(viewModel: FilmsViewModel = hiltViewModel(LocalContext.current as ComponentActivity)) {

    val film by viewModel.currentFilm.collectAsState()
    var isFavorite by rememberSaveable { mutableStateOf(false) }

    Column() {
        Box(contentAlignment = Alignment.BottomEnd) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                model = "${Constants.BASE_IMAGE_URI}${film.backdrop_path}",
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            IconButton(modifier = Modifier.padding(4.dp), onClick = {
                isFavorite = true
                viewModel.addItemToFavorites(
                    FavoriteFilm(
                        id = film.id,
                        adult = film.adult,
                        backdropPath = film.backdrop_path,
                        originalLanguage = film.original_language,
                        title = film.title,
                        overview = film.overview,
                        popularity = film.popularity,
                        posterPath = film.poster_path,
                        releaseDate = film.releaseDate,
                        voteAverage = film.vote_average
                    )
                )
            }) {
                Icon(
                    Icons.Filled.Favorite,
                    null,
                    modifier = Modifier
                        .size(36.dp)
                        .shadow(elevation = 12.dp),
                    tint = if (isFavorite) Color.Red else Color.White
                )
            }
        }

        Text(
            text = film.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier.padding(start = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = film.overview,
                fontSize = 18.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Start
            )

            Row {
                Icon(Icons.Filled.Face, null, tint = Color.White)
                Text(
                    text = "Language:${film.original_language}",
                    color = Color.LightGray
                )
            }
            Row {
                Icon(Icons.Filled.Star, null, tint = Color.White)
                Text(text = "Rating:${film.vote_average}", color = Color.LightGray)
            }
            Row {
                Icon(Icons.Filled.ThumbUp, null, tint = Color.White)
                Text(
                    text = stringResource(R.string.popularity, film.popularity),
                    color = Color.LightGray
                )
            }
        }
    }
}


