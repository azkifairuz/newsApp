package com.azkifairuz.myapplication

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
@Composable
fun NewsList(newsViewModel: NewsViewModel) {
    val newsList = newsViewModel.newsList.collectAsLazyPagingItems()
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(newsList) { news ->
            NewsItem(news = news)
            Divider()
        }
        if (newsList.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
    LaunchedEffect(Unit) {
        val itemCount = newsList.snapshot().items.size
        val lastVisibleItemIndex = scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index

        if (lastVisibleItemIndex != null && itemCount - lastVisibleItemIndex < 5) {
            newsList.loadState
        }
    }

}

@Composable
fun NewsItem(news: News?) {
    if (news != null) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = news.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = news.description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = rememberImagePainter(
                    data = news.urlToImage,
                    builder = {
                        transformations(RoundedCornersTransformation(4f))
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }
    }
}


