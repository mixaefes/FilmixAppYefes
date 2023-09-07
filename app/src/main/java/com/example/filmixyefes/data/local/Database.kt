package com.example.filmixyefes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteFilm::class], version = 1, exportSchema = false)
abstract class FilmsDatabase : RoomDatabase() {
    abstract fun favoritesFilmsDao(): Dao
}