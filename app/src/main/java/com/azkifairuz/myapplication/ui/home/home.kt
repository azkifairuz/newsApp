package com.azkifairuz.myapplication.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
            Log.e("HOHO",news.urlToImage)
            NewsCard(news = news)
        }
    }
}

@Composable
fun NewsCard(news: NewsItem) {



    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxSize()
    ){
        Column() {
            Image(
                painter = rememberAsyncImagePainter(model = news.urlToImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                
                Text(text = news.title, fontWeight = FontWeight.Bold)
                Text(text = news.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
                
            }
        }
    }
}
