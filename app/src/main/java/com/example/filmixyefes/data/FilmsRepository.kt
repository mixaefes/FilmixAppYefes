package com.example.filmixyefes.data

import android.util.Log
import com.example.filmixyefes.data.local.Dao
import com.example.filmixyefes.data.local.FavoriteFilm
import com.example.filmixyefes.data.remote.RetrofitInstance
import com.example.filmixyefes.model.PopularFilmsList
import com.skydoves.sandwich.isFailure
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

private const val TAG = "FilmsRepository"

class FilmsRepository @Inject constructor(private val filmsDao: Dao) {

    //Database
    val allFavoritesFilms: Flow<List<FavoriteFilm>> = filmsDao.getAll()

    fun insertFavoriteFilm(film: FavoriteFilm) {
        filmsDao.insertFilm(film)
    }

    //Network
    suspend fun getPopularFilms(page: Int): Flow<PopularFilmsList> = flow {
        RetrofitInstance.api.getPopularFilmsList(page).suspendOnSuccess {
            //Here you can add a callback that the request to get popular films was successful
            Log.d(TAG, "suspendOnSuccess")
            emit(data)
        }.suspendOnError {
            //Here we add a callback that shows and explains the error that occurred
            Log.d(TAG, "OnError: $errorBody")
        }.suspendOnException {
            Log.d(TAG, "OnException $exception")
        }.suspendOnFailure {
            Log.d(TAG, "OnFailure $isFailure")
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getNowPlayingFilms(page: Int): Flow<PopularFilmsList> = flow {
        RetrofitInstance.api.getNowPlayingFilmsList(page).suspendOnSuccess {
            //Here we can add a callback that the request to get broadcast films was successful
            Log.d(TAG, "suspendOnSuccess")
            emit(data)
        }.suspendOnError {
            Log.d(TAG, "OnError: $errorBody")
        }.suspendOnException {
            Log.d(TAG, "OnException $exception")
        }.suspendOnFailure {
            Log.d(TAG, "OnException")
        }
    }.flowOn(Dispatchers.IO)
}