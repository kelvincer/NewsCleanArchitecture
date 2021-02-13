package com.homecleanarchitecture.domain.home

data class News(
    val title: String, val description: String, val urlToImage: String?,
    val url: String, val publishedAt: String, val origin: String,
    val address: String
)