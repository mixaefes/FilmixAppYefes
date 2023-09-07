package com.example.filmixyefes.data.remote

import com.example.filmixyefes.utils.Constants
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: FilmsApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URI)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(FilmsApi::class.java)
    }
}
