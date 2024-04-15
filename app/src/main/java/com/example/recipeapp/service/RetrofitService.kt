package com.example.recipeapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: ApiService = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)