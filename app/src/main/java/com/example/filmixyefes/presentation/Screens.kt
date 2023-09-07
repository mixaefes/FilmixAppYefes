package com.example.filmixyefes.presentation

sealed class Screens(val route: String) {

    data object MainScreen : Screens(route = "main_screen")
    data object FavoritesScreen : Screens(route = "favorites_screen")
    data object DetailsScreen : Screens(route = "details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/arg")
            }
        }
    }
}
