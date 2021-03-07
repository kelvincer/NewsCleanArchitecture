package com.home.rosarionews.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homecleanarchitecture.domain.home.News
import com.homecleanarchitecture.usecases.home.RequestNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val requestNews: RequestNews) : ViewModel() {

    val TAG = MainViewModel::class.java.canonicalName

    private val _newsStateFlow = MutableStateFlow<List<News>>(emptyList())
    val newsStateFlow = _newsStateFlow

    private val _visibilityLiveData = MutableLiveData<Boolean>()
    val visibilityLiveData: LiveData<Boolean>
        get() = _visibilityLiveData

    private val _newsLiveData = MutableLiveData<List<News>>()
    val newsLiveData = _newsLiveData

    /*init {
        viewModelScope.launch {
            _visibilityLiveData.value = true
            val news = requestNews.getNews()
            _newsStateFlow.value = news
            _visibilityLiveData.value = false
        }
    }*/

    init {
        viewModelScope.launch {
            _visibilityLiveData.value = true
            val news = requestNews.getNews()
            _newsLiveData.value = news
            _visibilityLiveData.value = false
        }
    }
}