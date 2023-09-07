package com.example.filmixyefes.data.local

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM favoritefilm")
    fun getAll(): Flow<List<FavoriteFilm>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: FavoriteFilm)
}