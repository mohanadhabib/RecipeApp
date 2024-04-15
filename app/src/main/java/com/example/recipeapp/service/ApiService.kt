package com.example.recipeapp.service

import com.example.recipeapp.model.CategoriesList
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories():CategoriesList
}