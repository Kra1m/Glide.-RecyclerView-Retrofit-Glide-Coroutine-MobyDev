package com.example.retrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "https://uselessfacts.jsph.pl"
    private const val BASE_URL_MEMES = "https://api.imgflip.com/"

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    private val retrofitMemes: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL_MEMES).addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val apiServiceToday: ApiServiceTodayFact = retrofit.create(ApiServiceTodayFact::class.java)
    val apiServiceMemes: ApiService = retrofitMemes.create((ApiService::class.java))

}