package com.azkifairuz.myapplication.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.azkifairuz.myapplication.domain.item.NewsItem

@Composable
fun HomeScreen() {
    
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val news by homeViewModel.news.collectAsState()
    
    LazyColumn{
        items(news) {news: NewsItem ->

            NewsCard(news = news)
        }
    }
}

@Composable
fun NewsCard(news: NewsItem) {

    val image = rememberAsyncImagePainter(model = news.urlToImage)

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxSize()
    )
}
