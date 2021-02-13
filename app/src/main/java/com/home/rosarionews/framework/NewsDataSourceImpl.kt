package com.home.rosarionews.framework

import com.home.rosarionews.api.ServiceApi
import com.homecleanarchitecture.data.NewsDataSource
import com.homecleanarchitecture.data.home.response.NewsApiResponse
import retrofit2.Retrofit
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : NewsDataSource {

    override suspend fun getServiceNews(q: String): NewsApiResponse {
        val service = retrofit.create(ServiceApi::class.java)
        return service.getNews(q)
    }
}

