package com.example.recipeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.model.Category

@Composable
fun CategoryDetailsScreen(category:Category){
    val scroll = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().padding(
            vertical = 18.dp,
            horizontal = 10.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = category.strCategory,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = "",
            modifier = Modifier.aspectRatio(1F))
        Text(
            text = category.strCategoryDescription,
            fontSize = 15.sp,
            modifier = Modifier
                .wrapContentSize()
                .verticalScroll(scroll)
        )
    }
}
