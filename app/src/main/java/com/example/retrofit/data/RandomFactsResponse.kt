package com.example.retrofit.data

data class RandomFactsResponse(
    val id: String,
    val language: String,
    val permalink: String,
    val source: String,
    val source_url: String,
    val text: String
)