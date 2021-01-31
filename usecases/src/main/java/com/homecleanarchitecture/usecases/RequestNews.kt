package com.homecleanarchitecture.usecases

import com.homecleanarchitecture.data.NewsRepository
import com.homecleanarchitecture.domain.News
import javax.inject.Inject

class RequestNews @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getNews(): List<News>{
        return newsRepository.requestNews()
    }
}