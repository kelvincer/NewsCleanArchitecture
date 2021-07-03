package com.homecleanarchitecture.data.home.repositories

import com.homecleanarchitecture.data.home.datasources.NewsDataSource
import com.homecleanarchitecture.domain.home.News
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

    suspend fun requestNews(): List<News> {
        return newsDataSource.getServiceNews("bitcoin")
    }
}
