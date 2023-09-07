package com.example.filmixyefes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.filmixyefes.R
import com.example.filmixyefes.ui.theme.FilmixYefesTheme
import com.example.filmixyefes.utils.Constants

@Composable
fun FilmListItem(
    title: String,
    language: String,
    posterPath: String,
    raiting: String,
    movieId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .fillMaxWidth()
            .background(color = Color.DarkGray, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onSurface)
    ) {
        Row {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = "${Constants.BASE_IMAGE_URI}$posterPath",
                contentDescription = null,
                modifier = Modifier
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(
                modifier = Modifier.padding(vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Row() {
                    Icon(Icons.Filled.Face, null, tint = Color.Gray)
                    Text(text = stringResource(R.string.language), color = Color.Gray)
                    Text(text = language, color = Color.Gray)

                }
                Row {
                    Icon(Icons.Filled.Star, null, tint = Color.Yellow)
                    Text(text = raiting, color = Color.White)
                }
            }
        }
    }
}


@Preview
@Composable
fun FilmListItemPreview() {
    MaterialTheme {
        // FilmListItem(title = "Terminator", language = "English", posterPath = "", movieId = 1)
    }
}