package com.homecleanarchitecture.data.home.datasources

import com.homecleanarchitecture.domain.home.News

interface NewsDataSource {
    suspend fun getServiceNews(q: String): List<News>
}
