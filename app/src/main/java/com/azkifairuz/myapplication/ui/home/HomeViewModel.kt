package com.azkifairuz.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azkifairuz.myapplication.domain.GetNewsUseCase
import com.azkifairuz.myapplication.domain.item.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase):ViewModel() {

    private val  _news = MutableStateFlow(emptyList<NewsItem>())
    val news: StateFlow<List<NewsItem>> get() = _news

    init {
        getNews()
    }

    private fun getNews() =viewModelScope.launch {

        getNewsUseCase()
            .onEach {
                _news.tryEmit(it)
            }
            .collect()
    }

}