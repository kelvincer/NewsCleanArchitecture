package com.home.rosarionews.framework

import com.home.rosarionews.api.ServiceApi
import com.homecleanarchitecture.data.home.datasources.NewsDataSource
import com.homecleanarchitecture.domain.home.News
import javax.inject.Inject

class ServerNewsDataSource @Inject constructor(private val serviceApi: ServiceApi) :
    NewsDataSource {

    override suspend fun getServiceNews(q: String): List<News> {
        val response = serviceApi.getNews(q)
        return response.articles.map { article ->
            News(
                article.title,
                article.description,
                article.urlToImage,
                article.url,
                article.publishedAt,
                article.source.name,
                ""
            )
        }
    }
}

