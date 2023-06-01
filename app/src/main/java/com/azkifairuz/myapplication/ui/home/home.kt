package com.azkifairuz.myapplication.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val news by homeViewModel.news.collectAsState()
    
    LazyColumn{
        item (news) {news:newsItem->
            
            NewsCard(news = news)
        }
    }
}

@Composable
fun NewsCard(news: Any) {

}
