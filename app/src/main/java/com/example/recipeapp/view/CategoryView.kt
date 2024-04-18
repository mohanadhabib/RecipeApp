package com.example.recipeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.model.Category
import com.example.recipeapp.viewModel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel:CategoryViewModel,
    navigate:(Category)->Unit){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize()
            .padding(
                vertical = 8.dp,
                horizontal = 10.dp
            ),
        columns = GridCells.Fixed(2)
    ) {
        items(viewModel.listOfCategory.value.categories){
            item -> CategoryItem(category = item , navigate = navigate)
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    navigate: (Category) -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                       navigate(category)
            },
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