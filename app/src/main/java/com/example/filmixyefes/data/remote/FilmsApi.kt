package com.example.filmixyefes.data.remote

import com.example.filmixyefes.model.NowPlayingFilmsList
import com.example.filmixyefes.model.PopularFilmsList
import com.example.filmixyefes.utils.Constants
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmsApi {

    @GET("popular?language=en-US")
    @Headers("Content-Type: application/json","Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getPopularFilmsList(
        @Query("page") page: Int,
    ): ApiResponse<PopularFilmsList>

    @GET("now_playing?language=en-US")
    @Headers("Content-Type: application/json","Authorization: Bearer ${Constants.API_TOKEN}")
    suspend fun getNowPlayingFilmsList(
        @Query("page") page: Int
    ): ApiResponse<PopularFilmsList>

}

