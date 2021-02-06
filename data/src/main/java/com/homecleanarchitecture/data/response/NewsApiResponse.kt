package com.homecleanarchitecture.data.response

import com.homecleanarchitecture.domain.News

data class NewsApiResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)

data class Article(
    val source: Source,
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String? = null
)

data class Source(
    val id: String? = null,
    val name: String
)

fun NewsApiResponse.toDomainNews(): List<News> = articles.map {
    News(
        it.title, it.description,
        it.urlToImage, it.url, it.publishedAt, it.source.name
    )
}
