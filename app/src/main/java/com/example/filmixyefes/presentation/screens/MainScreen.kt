package com.example.filmixyefes.presentation.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.filmixyefes.R
import com.example.filmixyefes.presentation.viewmodels.FilmsViewModel
import com.example.filmixyefes.presentation.Screens
import com.example.filmixyefes.presentation.components.FilmListItem
import com.example.filmixyefes.ui.theme.FilmixYefesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: FilmsViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navController: NavController
) {

    val popularFilmsList by viewModel.popularFilmsList.collectAsState()
    val isShowNowPlaying = viewModel.isShowNowPlayingFilms
    val currentPage = viewModel.currentPage

    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.filmix),
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 12.dp)
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black),
            actions = {
                IconButton(onClick = { navController.navigate(Screens.FavoritesScreen.route) }) {
                    Icon(Icons.Filled.Favorite, null)
                }
                IconButton(onClick = {
                    viewModel.setIsShowNowPlayingFilmsList()
                }) {
                    Icon(
                        Icons.Filled.DateRange,
                        null,
                        tint = if (isShowNowPlaying) Color.LightGray else Color.DarkGray
                    )
                }
            })
        if (popularFilmsList.results.isNotEmpty()) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                items(items = popularFilmsList.results) { item ->
                    FilmListItem(
                        title = item.title,
                        language = item.originalLanguage,
                        posterPath = item.posterPath,
                        movieId = item.id,
                        raiting = item.voteAverage.toString(),
                        onClick = {
                            viewModel.setCurrentFilmId(item.id)
                            navController.navigate(Screens.DetailsScreen.route)
                        })
                }
                item {
                    Row(
                        modifier = Modifier.padding(vertical = 22.dp, ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            enabled = currentPage > 1,
                            onClick = {viewModel.onPrevPage()},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                        ) {
                            Text(text = stringResource(R.string.prev_page))
                        }
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        Text(text = "Page:", fontSize = 24.sp, color = Color.LightGray)
                        Text(
                            text = popularFilmsList.page.toString(),
                            fontSize = 24.sp,
                            color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        Button(
                            onClick = { viewModel.onNextPage() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                        ) {
                            Text(text = stringResource(R.string.next_page))
                        }
                    }
                }
            }
        } else {
            Text(text = stringResource(id = R.string.there_s_nothing_to_show))
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    FilmixYefesTheme {
    }
}