package com.homecleanarchitecture.usecases.home

import com.homecleanarchitecture.data.home.NewsRepository
import com.homecleanarchitecture.domain.home.News
import javax.inject.Inject

class RequestNews @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getNews(): List<News>{
        return newsRepository.requestNews()
    }
}