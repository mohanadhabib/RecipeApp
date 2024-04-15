package com.example.recipeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.model.Category
import com.example.recipeapp.viewModel.CategoryViewModel

@Composable
fun CategoryScreen(viewModel:CategoryViewModel){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3)
    ) {
        items(viewModel.listOfCategory.value.categories){
            item -> CategoryItem(category = item)
        }
    }
}

@Composable
fun CategoryItem(category: Category){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = rememberAsyncImagePainter(
                model = category.strCategoryThumb,
            ),
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1F),
            contentDescription = ""
        )
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
}