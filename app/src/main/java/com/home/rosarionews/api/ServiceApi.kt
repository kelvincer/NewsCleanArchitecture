package com.home.rosarionews.api

import com.homecleanarchitecture.data.response.NewsApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String = "cf7040765efa4f8ab7f02fea2019f731"
    ): NewsApiResponse
}