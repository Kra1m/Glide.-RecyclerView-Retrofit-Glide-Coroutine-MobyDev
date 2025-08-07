package com.example.retrofit.data

import retrofit2.http.GET

interface ApiServiceTodayFact {
    @GET("/api/v2/facts/today")
    suspend fun getTodayFacts():RandomTodayFact
}