package com.home.rosarionews.framework

import com.home.rosarionews.api.ServiceApi
import com.homecleanarchitecture.data.home.NewsDataSource
import com.homecleanarchitecture.data.home.response.NewsApiResponse
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private val serviceApi: ServiceApi) : NewsDataSource {

    override suspend fun getServiceNews(q: String): NewsApiResponse {
        return serviceApi.getNews(q)
    }
}

