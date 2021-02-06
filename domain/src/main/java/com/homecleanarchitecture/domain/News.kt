package com.homecleanarchitecture.domain

data class News(
    val title: String, val description: String, val urlToImage: String?,
    val url: String, val publishedAt: String
)