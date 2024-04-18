package com.example.recipeapp.constant

sealed class NavConstants (val route:String = "CategoryScreen") {
    data object CategoryScreen : NavConstants("CategoryScreen")
    data object CategoryDetailsScreen : NavConstants("CategoryDetailsScreen")
}