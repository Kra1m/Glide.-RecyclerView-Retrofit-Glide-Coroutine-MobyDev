package com.example.retrofit.data

import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/facts/random")
    suspend fun getFacts():RandomFactsResponse

    @GET("get_memes")
    suspend fun getMemes():MemesResponse
}

