package com.example.filmixyefes.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.filmixyefes.R
import com.example.filmixyefes.presentation.viewmodels.FavoritesViewModel
import com.example.filmixyefes.presentation.components.FilmListItem

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
    val allFavoritesFilmList by viewModel.allFavoritesFilms.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
        Text(
            text = stringResource(R.string.favorites),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        if (allFavoritesFilmList.isNotEmpty()) {
            LazyColumn() {
                itemsIndexed(items = allFavoritesFilmList) { index, item ->
                    FilmListItem(
                        title = item.title.toString(),
                        language = item.originalLanguage.toString(),
                        posterPath = item.posterPath.toString(),
                        raiting = item.voteAverage.toString(),
                        movieId = item.id,
                        onClick = {}
                    )
                }
            }
        } else {
            Text(
                text = stringResource(R.string.there_s_nothing_to_show),
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }
    }
}