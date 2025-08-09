package com.example.retrofit.dog

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDog {
    private const val BASE_URL_DOGS = "https://dog.ceo/api/"

    private val retrofitDogsPic: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL_DOGS).addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiServiceDog: ApiServiceDog = retrofitDogsPic.create(ApiServiceDog::class.java)
}