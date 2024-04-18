package com.example.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.constant.NavConstants
import com.example.recipeapp.model.Category
import com.example.recipeapp.view.CategoryDetailsScreen
import com.example.recipeapp.view.CategoryScreen
import com.example.recipeapp.viewModel.CategoryViewModel

@Composable
fun AppNavigation(viewModel: CategoryViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavConstants.CategoryScreen.route) {
        composable(NavConstants.CategoryScreen.route){
            CategoryScreen(viewModel = viewModel){ item ->
                navController.currentBackStackEntry?.savedStateHandle?.set("item",item)
                navController.navigate(NavConstants.CategoryDetailsScreen.route)
            }
        }
        composable(NavConstants.CategoryDetailsScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("item")?: Category("","","","")
            CategoryDetailsScreen(category = category)
        }
    }
}