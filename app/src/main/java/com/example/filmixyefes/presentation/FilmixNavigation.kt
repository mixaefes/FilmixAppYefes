package com.example.filmixyefes.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmixyefes.presentation.screens.DetailsScreen
import com.example.filmixyefes.presentation.screens.FavoritesScreen
import com.example.filmixyefes.presentation.screens.MainScreen

@Composable
fun FilmixNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {

        composable(Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(Screens.FavoritesScreen.route) {
            FavoritesScreen()
        }
        composable(Screens.DetailsScreen.route) {
            DetailsScreen()
        }
    }
}




