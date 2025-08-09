package com.example.retrofit.dog

import retrofit2.http.GET

interface ApiServiceDog {
    @GET ("breeds/image/random/4")
    suspend fun getRandomDog(): DogsResponse
}