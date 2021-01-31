package com.home.rosarionews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homecleanarchitecture.domain.News
import com.homecleanarchitecture.usecases.RequestNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val requestNews: RequestNews) : ViewModel() {

    val TAG = MainViewModel::class.java.canonicalName

    private val _visibilityLiveData = MutableLiveData<Boolean>()
    val visibilityLiveData: LiveData<Boolean>
        get() = _visibilityLiveData

    private val _newsLiveData = MutableLiveData<List<News>>()
    val newsLiveData: LiveData<List<News>>
        get() = _newsLiveData

    init {
        viewModelScope.launch {
            //val newsRepository = NewsRepository(NewsDataSourceImpl(retrofit))
            //val requestNews = RequestNews(newsRepository)
            _visibilityLiveData.value = true
            val news = requestNews.getNews()
            _newsLiveData.value = news
            _visibilityLiveData.value = false
        }
    }
}