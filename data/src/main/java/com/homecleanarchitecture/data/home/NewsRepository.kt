package com.homecleanarchitecture.data.home

import com.homecleanarchitecture.data.home.response.NewsApiResponse
import com.homecleanarchitecture.data.home.response.toDomainNews
import com.homecleanarchitecture.domain.home.News
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

    suspend fun requestNews(): List<News> {
        val news = newsDataSource.getServiceNews("bitcoin")
        return news.toDomainNews()
    }
}

interface NewsDataSource {
    suspend fun getServiceNews(q: String): NewsApiResponse
}
